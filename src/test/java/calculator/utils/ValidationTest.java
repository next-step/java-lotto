package calculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

	@Test
	@DisplayName("문자열에 빈값을 입력하면 예외가 발생된다.")
	public void validStringEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validStringEmptyCheck("")
		);
	}

	@Test
	@DisplayName("문자열에 숫자타입을 입력안할시  예외가 발생된다.")
	public void validNumberTypeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validNumberTypeCheck("!")
		);
	}

	@Test
	@DisplayName("숫자에 음수를 입력할시 예외가 발생된다.")
	public void validPositiveNumber() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validPositiveNumber(-1)
		);
	}

}