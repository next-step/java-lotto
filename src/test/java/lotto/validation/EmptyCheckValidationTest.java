package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmptyCheckValidationTest {

	@Test
	@DisplayName("입력값이 반값이면 예외가 발생한다..")
	public void validEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			EmptyCheckValidation.validEmptyCheck("")
		);
	}
}