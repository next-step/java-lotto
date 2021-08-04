package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTypeValidationTest {

	@Test
	@DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
	public void validNumberTypeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			NumberTypeValidation.validNumberTypeCheck("!")
		);
	}
}