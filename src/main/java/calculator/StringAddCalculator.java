package calculator;

import java.util.Objects;

public class StringAddCalculator {
	public static final String DELIMITER = ",|:";
	public static int splitAndSum(String text) {
		if (Objects.isNull(text) || text.isEmpty()) {
			return 0;
		}

		String[] nums = text.split(DELIMITER);
		int sum = 0;

		for (String num : nums) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}
}
