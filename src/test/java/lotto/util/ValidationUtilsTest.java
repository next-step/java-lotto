package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidationUtilsTest {

	@DisplayName("로또 번호 유효성 체크 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ", "1", "11,2,3,4,5,6, ", "1.1.1.1.1.1", "12,23,44,56,87", "1,2,3,4,5,6,",
		"   13,2,3,4,5,6 ", "123,2,3,4,5,6"})
	void invalid_lotto_number_pattern(String numberString1) {
		// then
		boolean valid = ValidationUtils.validateNumbersPattern(numberString1);

		// then
		assertThat(valid).isFalse();
	}

	@DisplayName("Collection 유효성 체크 테스트")
	@Test
	void invalid_collection() {
		// given
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// when
		boolean valid = ValidationUtils.validateCollection(list, 6);

		// then
		assertThat(valid).isFalse();
	}

	@DisplayName("숫자 문자열 유효성 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   ", "1,", ",", "     1      "})
	void invalid_number_string(String number) {
		// when
		boolean valid = ValidationUtils.validateNumber(number);

		// then
		assertThat(valid).isFalse();
	}

}
