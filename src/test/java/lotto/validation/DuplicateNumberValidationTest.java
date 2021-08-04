package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DuplicateNumberValidationTest {

	@Test
	@DisplayName("중복된 당첨번호가 존재하면 예외가 발생된다.")
	public void validDuplicateNumberCheck() {
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(3);
		values.add(1);
		assertThrows(IllegalArgumentException.class, () ->
			DuplicateNumberValidation.validDuplicateNumberCheck(values)
		);
	}
}