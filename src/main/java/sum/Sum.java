package sum;

import java.util.Arrays;
import java.util.List;

public class Sum {
	public static int sum(String sumParam) {
		List<String> values = Arrays.asList(sumParam.split("[,:]",-1));
		validationCheck(values);
		return values.stream()
				.mapToInt(Integer::parseInt)
				.sum();
	}

	private static void validationCheck(List<String> values) {
		for (String value : values) {
			if (value == null ||
					value.isEmpty()) {
				throw new IllegalArgumentException("value is Empty");
			}

			if(Integer.parseInt(value) < 0){
				throw new IllegalArgumentException("value is negative");
			}
		}
	}
}
