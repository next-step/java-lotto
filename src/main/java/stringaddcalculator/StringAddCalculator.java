package stringaddcalculator;

/**
 * @author : byungkyu
 * @date : 2020/12/11
 * @description :
 **/
public class StringAddCalculator {

	public static int splitAndSum(String input) {

		String target = isNullOrEmpty(input) ? "0" : input;
		Numbers numbers = new Numbers(target);
		return numbers.sum();
	}

	private static boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

}
