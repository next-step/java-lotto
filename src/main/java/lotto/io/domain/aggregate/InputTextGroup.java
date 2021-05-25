package lotto.io.domain.aggregate;

import java.util.Collections;
import java.util.List;

import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextListException;

public class InputTextGroup {
	private final List<InputText> inputTexts;

	private InputTextGroup(List<InputText> inputTexts) {
		this.inputTexts = inputTexts;
	}

	public static InputTextGroup generate(List<InputText> unmodifiableInputTexts) throws IllegalInputTextListException {
		validateGenerate(unmodifiableInputTexts);
		return new InputTextGroup(unmodifiableInputTexts);
	}

	public List<InputText> inputTexts() {
		return Collections.unmodifiableList(inputTexts);
	}

	private static void validateGenerate(List<InputText> unmodifiableInputTexts) throws IllegalInputTextListException {
		validateNotNullOrNotEmpty(unmodifiableInputTexts);
	}

	private static void validateNotNullOrNotEmpty(List<InputText> unmodifiableInputTexts) throws
		IllegalInputTextListException {
		if (unmodifiableInputTexts == null || unmodifiableInputTexts.isEmpty()) {
			throw new IllegalInputTextListException("최소 1개 이상의 입력값이 존재해야 합니다.");
		}
	}

}
