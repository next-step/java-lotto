package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberPositiveValidationTest {

	@Test
	@DisplayName("참여금액이 0원 미만이면 예외가 발생된다.")
	public void validPositiveCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			NumberPositiveValidation.validPositiveCheck(-1)
		);
	}
}
