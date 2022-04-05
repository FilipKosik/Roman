package filip.kosik.demo.RomanNumeral.service;


/**
 * Interface keeps original RomanNumeralConverter (from task) and it adds universal smart convert method.
 */
public interface MyRomanNumeralConverter extends RomanNumeralConverter {
	public String convert(String value);
}
