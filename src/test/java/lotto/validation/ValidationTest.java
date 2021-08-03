package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

	@Test
	@DisplayName("구입금액이 천단위가 아니면 예외가 발생된다.")
	public void validThousandUnitCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validThousandUnitCheck(12500)
		);
	}

	@Test
	@DisplayName("입력값이 반값이면 예외가 발생한다..")
	public void validEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validEmptyCheck("")
		);
	}

	@Test
	@DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
	public void validNumberTypeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validNumberTypeCheck("!")
		);
	}

	@Test
	@DisplayName("로또의 볼은 6개가 아니면 예외가 발생한다.")
	public void validLottoSizeCheck() {
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validLottoSizeCheck(new String[] {"1", "2", "3", "4"})
		);
	}

	@Test
	@DisplayName("중복된 당첨번호가 존재하면 예외가 발생된다.")
	public void validDuplicateNumberCheck() {
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(3);
		values.add(1);
		assertThrows(IllegalArgumentException.class, () ->
			Validation.validDuplicateNumberCheck(values)
		);
	}
}