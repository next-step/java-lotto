package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class SeparatedInputValues {
	private final List<InputValue> separatedInputValue;

	public SeparatedInputValues(List<String> separatedInputText) {
		this.separatedInputValue = separatedInputText
			.stream()
			.map(InputValue::new)
			.collect(Collectors.toList());
	}

	public static SeparatedInputValues ofSeparator(List<String> separator) {
		return new SeparatedInputValues(separator);
	}


	public int sum() {
		return separatedInputValue.stream().map(InputValue::getValue).reduce(0, Integer::sum);
	}

}
