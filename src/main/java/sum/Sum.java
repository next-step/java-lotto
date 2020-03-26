package sum;

import java.util.Arrays;

public class Sum {
	public static int sum(String sumParam) {
		return Arrays.stream(sumParam.split("[,:]"))
				.mapToInt(Integer::parseInt)
				.sum();
	}
}
