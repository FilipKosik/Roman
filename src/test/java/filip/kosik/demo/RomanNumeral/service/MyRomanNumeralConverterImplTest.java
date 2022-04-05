package filip.kosik.demo.RomanNumeral.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filip.kosik.demo.RomanNumeral.MyRomanNumeralConverter;
import filip.kosik.demo.RomanNumeral.service.MyRomanNumeralConverter;
import filip.kosik.demo.RomanNumeral.service.MyRomanNumeralConverterImpl;

public class MyRomanNumeralConverterImplTest {

	private MyRomanNumeralConverter testedConverter;
	
	@BeforeEach                                         
    public void setUp() {
        testedConverter = new MyRomanNumeralConverterImpl();
    }
	
	@Test
	public void testToRomanNumeralNegative() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.toRomanNumeral(-1));
	}
	
	@Test
	public void testToRomanNumeralZero() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.toRomanNumeral(0));
	}
	
	@Test
	public void testToRomanNumeralMax() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.toRomanNumeral(4000));
	}
	
	@Test
	public void testToRomanNumeral1() {
		assertEquals("I", testedConverter.toRomanNumeral(1));
	}
	
	@Test
	public void testToRomanNumeral1000() {
		assertEquals("M", testedConverter.toRomanNumeral(1000));
	}

	@Test
	public void testToRomanNumeral1111() {
		assertEquals("MCXI", testedConverter.toRomanNumeral(1111));
	}

	@Test
	public void testToRomanNumeral2222() {
		assertEquals("MMCCXXII", testedConverter.toRomanNumeral(2222));
	}

	@Test
	public void testToRomanNumeral3333() {
		assertEquals("MMMCCCXXXIII", testedConverter.toRomanNumeral(3333));
	}

	@Test
	public void testToRomanNumeral444() {
		assertEquals("CDXLIV", testedConverter.toRomanNumeral(444));
	}
	
	@Test
	public void testToRomanNumeral1555() {
		assertEquals("MDLV", testedConverter.toRomanNumeral(1555));
	}

	@Test
	public void testToRomanNumeral2666() {
		assertEquals("MMDCLXVI", testedConverter.toRomanNumeral(2666));
	}

	@Test
	public void testToRomanNumeral2777() {
		assertEquals("MMDCCLXXVII", testedConverter.toRomanNumeral(2777));
	}

	@Test
	public void testToRomanNumeral2888() {
		assertEquals("MMDCCCLXXXVIII", testedConverter.toRomanNumeral(2888));
	}
	
	@Test
	public void testToRomanNumeral3999() {
		assertEquals("MMMCMXCIX", testedConverter.toRomanNumeral(3999));
	}
	
	@Test
	public void testToRomanNumeral246() {
		assertEquals("CCXLVI", testedConverter.toRomanNumeral(246));
	}
	
	@Test
	public void testToRomanNumeral789() {
		assertEquals("DCCLXXXIX", testedConverter.toRomanNumeral(789));
	}	
	
	@Test
	public void testToRomanNumeral2207() {
		assertEquals("MMCCVII", testedConverter.toRomanNumeral(2207));
	}
	
	
	@Test
	public void testFromRomanNumeralNotAlpha() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("1"));
	}
	
	@Test
	public void testFromRomanNumeralWrongAlpha() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("A"));
	}

	@Test
	public void testFromRomanNumeralTooMany() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("XXXX"));
	}

	@Test
	public void testFromRomanNumeralWrongOrderTenThousand() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("XM"));
	}

	@Test
	public void testFromRomanNumeralWrongOrderOneHundred() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("IC"));
	}
	
	@Test
	public void testFromRomanNumeralPlusMinus() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("IXI"));
	}

	@Test
	public void testFromRomanNumeralLowerCase() {
		assertEquals(90, testedConverter.fromRomanNumeral("xc"));
	}

	@Test
	public void testFromRomanNumeral1() {
		assertEquals(1, testedConverter.fromRomanNumeral("I"));
	}

	@Test
	public void testFromRomanNumeral1000() {
		assertEquals(1000, testedConverter.fromRomanNumeral("M"));
	}
	
	@Test
	public void testFromRomanNumeral1111() {
		assertEquals(1111, testedConverter.fromRomanNumeral("MCXI"));
	}
	
	@Test
	public void testFromRomanNumeral2222() {
		assertEquals(2222, testedConverter.fromRomanNumeral("MMCCXXII"));
	}
	
	@Test
	public void testFromRomanNumeral3333() {
		assertEquals(3333, testedConverter.fromRomanNumeral("MMMCCCXXXIII"));
	}
	
	@Test
	public void testFromRomanNumeral444() {
		assertEquals(444, testedConverter.fromRomanNumeral("CDXLIV"));
	}

	@Test
	public void testFromRomanNumeral555() {
		assertEquals(555, testedConverter.fromRomanNumeral("DLV"));
	}

	@Test
	public void testFromRomanNumeral2666() {
		assertEquals(2666, testedConverter.fromRomanNumeral("MMDCLXVI"));
	}

	@Test
	public void testFromRomanNumeral3777() {
		assertEquals(3777, testedConverter.fromRomanNumeral("MMMDCCLXXVII"));
	}

	@Test
	public void testFromRomanNumeral1888() {
		assertEquals(1888, testedConverter.fromRomanNumeral("MDCCCLXXXVIII"));
	}
	
	@Test
	public void testFromRomanNumeral3999() {
		assertEquals(3999, testedConverter.fromRomanNumeral("MMMCMXCIX"));
	}
	
	@Test
	public void testFromRomanNumeral2438() {
		assertEquals(2438, testedConverter.fromRomanNumeral("MMCDXXXVIII"));
	}

	@Test
	public void testConvert0() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("0"));
	}
	
	@Test
	public void testConvertABC() {
		assertThrows(IllegalArgumentException.class, () -> testedConverter.fromRomanNumeral("ABC"));
	}
	
	@Test
	public void testConvert1234FromRoman() {
		assertEquals("MCCXXXIV", testedConverter.convert("1234"));
	}
	
	@Test
	public void testConvert1234ToRoman() {
		assertEquals("1234", testedConverter.convert("MCCXXXIV"));
	}
	
}
