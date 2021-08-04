package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSizeValidationTest {

	@Test
	@DisplayName("로또의 볼은 6개가 아니면 예외가 발생한다.")
	public void validLottoSizeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			LottoSizeValidation.validLottoSizeCheck(new String[] {"1", "2", "3", "4"})
		);
	}

}