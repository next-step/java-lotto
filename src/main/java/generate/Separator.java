package generate;

import java.util.Arrays;
import java.util.List;

public class Separator {
	private static final String SPLIT_COMMA_COLON = ",|:";

	public static List<String> split (String input) {
		return Arrays.asList(input.split(SPLIT_COMMA_COLON));
	}
}
