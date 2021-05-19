import java.util.Arrays;

public class StringAddCalculator {
	public static int splitAndSum(String inputText) {
		if (inputText == null || inputText.isEmpty()) {
			return 0;
		}

		return Arrays.stream(inputText.split("[,:]"))
				.map(Integer::parseInt)
				.reduce(0, Integer::sum);
	}
}
