package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Message;

class ValidationUtilsTest {
	@Test
	@DisplayName("음수를 넣으면 IllegalArgumentException이 발생한다.")
	void validatePositiveTest_ThrowIllegalArgumentExceptionWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validatePositive(-1))
			.withMessage(Message.INVALID_POSITIVE_NUMBER);
	}

	@Test
	@DisplayName("null이나 빈 리스트를 넣으면 IllegalArgumentException이 발생한다.")
	void validateEmpty() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validateEmpty(null))
			.withMessage(Message.INVALID_EMPTY_LIST);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> ValidationUtils.validateEmpty(new ArrayList<>()))
			.withMessage(Message.INVALID_EMPTY_LIST);
	}
}
