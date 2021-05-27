package lotto.io.domain.aggregate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.io.domain.vo.InputText;
import lotto.io.exception.IllegalInputTextListException;

public class InputTextGroup {
	private final List<InputText> inputTexts;

	private InputTextGroup(List<InputText> inputTexts) {
		this.inputTexts = inputTexts;
	}

	public static InputTextGroup generate(List<InputText> unmodifiableInputTexts) {
		validateGenerate(unmodifiableInputTexts);
		return new InputTextGroup(unmodifiableInputTexts);
	}

	public List<InputText> inputTexts() {
		return Collections.unmodifiableList(inputTexts);
	}

	private static void validateGenerate(List<InputText> unmodifiableInputTexts) {
		validateNotNull(unmodifiableInputTexts);
		validateNotEmpty(unmodifiableInputTexts);
	}

	private static void validateNotNull(Object object) {
		if (Objects.isNull(object)) {
			throw new IllegalInputTextListException("InputTextGroup 또는 List<InputText>가 null일 수 없습니다.");
		}
	}

	private static void validateNotEmpty(List<InputText> unmodifiableInputTexts) {
		if (unmodifiableInputTexts.isEmpty()) {
			throw new IllegalInputTextListException("최소 1개 이상의 입력값이 존재해야 합니다.");
		}
	}

	public static void validateInputTextGroup(InputTextGroup inputTextGroup) {
		validateNotNull(inputTextGroup);
		validateGenerate(inputTextGroup.inputTexts());
	}
}
