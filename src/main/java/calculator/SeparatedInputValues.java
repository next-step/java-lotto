package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeparatedInputValues {
	private final List<InputValue> separatedInputValue;

	public SeparatedInputValues(String targetText, String separator) {
		this.separatedInputValue = Arrays.stream(targetText.split(separator))
			.map(InputValue::new)
			.collect(Collectors.toList());
	}

	public static SeparatedInputValues ofSplit(String targetText, String separator) {
		return new SeparatedInputValues(targetText, separator);
	}


	public int sum() {
		return separatedInputValue.stream().map(InputValue::getValue).reduce(0, Integer::sum);
	}

}
