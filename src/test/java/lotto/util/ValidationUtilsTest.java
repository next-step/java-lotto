package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilsTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ", "1", "11,2,3,4,5,6, ", "1.1.1.1.1.1", "12,23,44,56,87", "1,2,3,4,5,6,",
		"   13,2,3,4,5,6 ", "123,2,3,4,5,6"})
	void invalid_lotto_number_pattern(String numberString1) {
		// then
		boolean valid = ValidationUtils.validateLottoNumberPattern(numberString1);

		// then
		assertThat(valid).isFalse();
	}

}
