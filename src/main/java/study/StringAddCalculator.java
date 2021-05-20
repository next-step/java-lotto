package study;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		int result = 0;
		if (input == null || input.isEmpty()) {
			return result;
		}

		String[] inputs = input.split(",");
		for(String str : inputs){
			result += Integer.parseInt(str);
		}
		return result;
	}

}
