package utils;

import exception.StringAddCalculatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import type.DecimalType;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static type.StringAddCalculatorExceptionType.NEGATIVE_TEXT;

class NumberUtilsTest {

	@ParameterizedTest(name = "BigDecimal 클래스를 이용해 divide 테스트. source[{0}], target[{1}], expected[{2}]")
	@CsvSource(value = {
		"100, 100, 1.00", "30, 100, 0.30", "10, 15, 0.67"
	})
	void mathRoundTest(final int source, final int target, final String expected) {
		// given
		BigDecimal sourceNumber = BigDecimal.valueOf(source);
		BigDecimal targetNumber = BigDecimal.valueOf(target);

		// when
		BigDecimal result = NumberUtils.mathRound(sourceNumber, targetNumber, DecimalType.PLACE_TWO);

		assertThat(result.equals(new BigDecimal(expected)))
			.isTrue();
	}

	@Test
	@DisplayName("문자를 숫자로 변환하여 총합을 구하는 기능 테스트")
	void sum() {
		String[] texts = {"1", "2", "3"};
		assertThat(NumberUtils.sumWithOutNegative(texts))
			.isEqualTo(6);
	}

	@ParameterizedTest(name = "Sum, int로 변환이 불가능한 케이스 테스트. value={0}")
	@MethodSource("parameterForSumWithNullAndEmpty")
	void sumWithNullAndEmpty(String[] texts) {
		assertThatExceptionOfType(NumberFormatException.class)
			.isThrownBy(()->NumberUtils.sumWithOutNegative(texts));
	}

	private static Stream<Arguments> parameterForSumWithNullAndEmpty() {
		return Stream.of(
			Arguments.of((Object) new String[]{"1", "", "3"}), 		// 빈값
			Arguments.of((Object) new String[]{"1", null, "3"}),	// null
			Arguments.of((Object) new String[]{"1", "$2", "3"}) 	// 숫자가 아닌 형태
						);
	}

	@Test
	@DisplayName("Sum, 음수가 포함된 케이스 테스트")
	void sumWithNagative() {
		// given
		String[] texts = {"1", "-2", "3"};

		// when
		assertThatExceptionOfType(StringAddCalculatorException.class)
			.isThrownBy(()->NumberUtils.sumWithOutNegative(texts))
			.withMessageContaining(NEGATIVE_TEXT.getMessage());
	}
}
