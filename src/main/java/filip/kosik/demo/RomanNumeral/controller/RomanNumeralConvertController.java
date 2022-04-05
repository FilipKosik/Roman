package filip.kosik.demo.RomanNumeral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filip.kosik.demo.RomanNumeral.service.MyRomanNumeralConverter;

@RestController
@RequestMapping("/roman")
public class RomanNumeralConvertController {


	@Autowired
	private MyRomanNumeralConverter romanNumeralConverter;

	
	@GetMapping("/{value}")
	public String findUserById(@PathVariable("value") String value) {
		return romanNumeralConverter.convert(value);
	}
	
}
