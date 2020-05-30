package study1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	
	private static final String DEFAULT_SPLIT = ",|:";
	private static final String CUSTOM_SPLIT =  "//(.)\n(.*)";
	
	private String customDelimiter;
	Validation validation = new Validation();
	Calculator calculator = new Calculator();
	String[] numbers;
	
	public int split(String inputString) {
		validation.emptyStringValidation(inputString); //validation check
		numbers = customsplitcalculator(inputString); // split
		validation.negativeValidation(numbers); //validation check
			
		return calculator.calculator(numbers); 
	}
	
	public String[] customsplitcalculator(String inputString) {
		String[] numbers = inputString.split(DEFAULT_SPLIT);
		
		Matcher m = Pattern.compile(CUSTOM_SPLIT).matcher(inputString);
		if (m.find()) {
			String customDelimiter = m.group(1);
			numbers = m.group(2).split(customDelimiter);
			
		}
		return numbers;
	}
}
