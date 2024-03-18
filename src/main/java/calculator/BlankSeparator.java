package calculator;

import java.util.List;

public class BlankSeparator extends StringSeparator {

	public static final String DELIMITER = " ";

	@Override
	protected List<String> splitByDelimiter(String input) {
		return List.of(input.split(DELIMITER));
	}

}
