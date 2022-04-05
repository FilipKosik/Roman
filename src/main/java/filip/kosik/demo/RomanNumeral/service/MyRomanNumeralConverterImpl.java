package filip.kosik.demo.RomanNumeral.service;

import java.util.regex.Pattern;

import com.google.common.collect.ImmutableBiMap;

//Note: This may be static "utility" class with static methods but the given interface was not static.
public class MyRomanNumeralConverterImpl implements MyRomanNumeralConverter {

	private final static ImmutableBiMap<Integer, Character> conversionToRomanMap = ImmutableBiMap.<Integer, Character>builder()
			.put(1000, 'M')
			.put(500, 'D')
			.put(100, 'C')
			.put(50, 'L')
			.put(10, 'X')
			.put(5, 'V')
			.put(1, 'I')
			.build();

	private final static ImmutableBiMap<Character, Integer> conversionFromRomanMap = conversionToRomanMap.inverse();
	
	private final static Pattern basicRomanPattern = Pattern.compile("^[MDCLXVI]+$", Pattern.CASE_INSENSITIVE);
	private final static Pattern basicDecimalPattern = Pattern.compile("^-?[0-9]{1,9}$", Pattern.CASE_INSENSITIVE);
	private final static Pattern strictRomanPattern = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$", Pattern.CASE_INSENSITIVE);
	
	
	@Override
	public String toRomanNumeral(int number) {
		if (number < 1 || number > 3999) {
			throw new IllegalArgumentException(String.format("Number %d is out of roman numerals range.", number));
		}
		
		// Note: This implementation iterates over decimal indexes. Other impl could add 4s to the map, take the greatest lower/equal value and use recursion.
		StringBuilder result = new StringBuilder();
		int remainder = number;
		int length = String.valueOf(number).length();
		for (int digitIndex = length-1; digitIndex >= 0; digitIndex--) {
			int indexAsDecimal = (int) Math.pow(10, digitIndex);
			int digitAsDecimal = remainder - (remainder % indexAsDecimal);
			remainder = remainder - digitAsDecimal;
			if (digitAsDecimal != 0) {
				if (digitAsDecimal == 4*indexAsDecimal || digitAsDecimal == 9*indexAsDecimal) {
					result.append(conversionToRomanMap.get(indexAsDecimal)).append(conversionToRomanMap.get(digitAsDecimal + indexAsDecimal));
				} else {
					if (digitAsDecimal >= 5*indexAsDecimal) {
						result.append(conversionToRomanMap.get(indexAsDecimal*5));
						digitAsDecimal -= indexAsDecimal*5;
					}
					while (digitAsDecimal > 0) {
						result.append(conversionToRomanMap.get(indexAsDecimal));
						digitAsDecimal -= indexAsDecimal;
					}
				}
			}
			if (remainder == 0){
				break; //optimize 1000 etc. but it is not necessary
			}
		}
		return result.toString();
	}
	
	
	@Override
	public int fromRomanNumeral(String romanNumeral) {
	    if(! strictRomanPattern.matcher(romanNumeral).find()) {
	    	throw new IllegalArgumentException("Invalid roman numeral.");
	    }
	    
	    int result = 0;
		int length = String.valueOf(romanNumeral).length();
		for (int romanIndex = 0; romanIndex < length; romanIndex++) {
			char romanDigit = romanNumeral.toUpperCase().charAt(romanIndex);
			if (romanIndex+1 < length && isOnesRomanDigit(romanDigit) && isLowerRomanDigit(romanDigit, romanNumeral.toUpperCase().charAt(romanIndex+1))) {
				result -= conversionFromRomanMap.get(romanDigit);
			} else {
				result += conversionFromRomanMap.get(romanDigit);
			}
		}
		return result;
	}
	
	
	public String convert(String value) {
		if(basicRomanPattern.matcher(value).find()) {
			return fromRomanNumeral(value) + "";
	    } else if (basicDecimalPattern.matcher(value).find()) {
	    	return toRomanNumeral(Integer.valueOf(value));
	    } else {
	    	throw new IllegalArgumentException("It is not roman numeral or decimal number or it is out of range.");
	    }
	}
	
	
	private boolean isOnesRomanDigit(char romanDigit) {
		return romanDigit == 'M' || romanDigit == 'C' || romanDigit == 'X' || romanDigit == 'I';
	}

	
	private boolean isLowerRomanDigit(char lowRomanDigit, char highRomanDigit) {
		return conversionFromRomanMap.get(lowRomanDigit) < conversionFromRomanMap.get(highRomanDigit);
	}
	
}
