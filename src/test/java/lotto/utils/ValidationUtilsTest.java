package lotto.utils;

import static org.assertj.core.api.Assertions.*;

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

}