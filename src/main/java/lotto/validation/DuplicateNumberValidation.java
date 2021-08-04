package lotto.validation;

import java.util.List;

import lotto.utils.ErrorMessage;

public class DuplicateNumberValidation {

	private DuplicateNumberValidation() {
	}

	public static void validDuplicateNumberCheck(List<Integer> values) {
		if (values.size() != values.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}
}
