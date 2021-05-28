package lotto.io.domain.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.io.domain.aggregate.InputTextGroup;
import lotto.io.exception.IllegalInputTextException;

public class InputText {
	public static final String COMMA_DELIMITER = ",";

	private final String value;

	private InputText(String text) {
		this.value = text.trim();
	}

	public static InputText generate(String text) {
		validateGenerate(text);
		return new InputText(text);
	}

	public String value() {
		return this.value;
	}

	public static void validateGenerate(String text) {
		validateNotNull(text);
		validateNotEmpty(text);
	}

	private static void validateNotNull(Object object) {
		if (Objects.isNull(object)) {
			throw new IllegalInputTextException("InputText 혹은 입력 값은 null일 수 없습니다.");
		}
	}

	private static void validateNotEmpty(String text) {
		if (text.trim().isEmpty()) {
			throw new IllegalInputTextException("입력 값은 공백의 문자열일 수 없습니다.");
		}
	}

	public static void validateNumberFormatInputText(InputText inputText) {
		validateInputText(inputText);
		try {
			Integer.parseInt(inputText.value);
		} catch (NumberFormatException e) {
			throw new IllegalInputTextException("Integer 값으로 parsing할 수 없습니다. 입력된 값 : " + inputText.value);
		}
	}

	public static void validateInputText(InputText inputText) {
		validateNotNull(inputText);
		validateGenerate(inputText.value);
	}

	public int parseInt() {
		return Integer.parseInt(value);
	}

	public InputTextGroup splitByComma() {
		List<InputText> inputTexts = new ArrayList<>();
		String[] splitInputTexts = this.value.split(COMMA_DELIMITER);
		for (String text : splitInputTexts) {
			inputTexts.add(generate(text));
		}
		return InputTextGroup.generate(Collections.unmodifiableList(inputTexts));
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof InputText)) {
			return false;
		}
		InputText inputText = (InputText)object;
		return Objects.equals(value, inputText.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "InputText{ value='" + value + "'}";
	}
}
