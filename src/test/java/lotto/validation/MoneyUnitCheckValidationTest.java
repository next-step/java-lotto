package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyUnitCheckValidationTest {

	@Test
	@DisplayName("구입금액이 천단위가 아니면 예외가 발생된다.")
	public void validThousandUnitCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			MoneyUnitCheckValidation.validThousandUnitCheck(12500)
		);
	}

}