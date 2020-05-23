package domain;

public class StringAddCalculator {

	public static int splitAndSum(String inputString) {
		String[] inputStringArray = inputString.split(":|,");
		int result = 0;
		for(String inputValue : inputStringArray) {
			result += Integer.parseInt(inputValue);
		}
		return result;
	}

}
