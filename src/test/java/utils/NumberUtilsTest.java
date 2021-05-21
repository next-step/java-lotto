package utils;

import exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static exception.LottoExceptionType.NEGATIVE_TEXT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

	@Test
	void mathRoundTest() {
		assertThat(NumberUtils.mathRound(100, 100, DecimalType.PLACE_TWO))
			.isEqualTo(1.0);

		assertThat(NumberUtils.mathRound(30, 100, DecimalType.PLACE_TWO))
			.isEqualTo(0.3);

		assertThat(NumberUtils.mathRound(10, 15, DecimalType.PLACE_TWO))
			.isEqualTo(0.67);
	}

	@Test
	@DisplayName("문자를 숫자로 변환하여 총합을 구하는 기능 테스트")
	void sum(){
		String[] texts = {"1", "2", "3"};
		assertThat(NumberUtils.sumWithOutNegative(texts))
			.isEqualTo(6);
	}

	@ParameterizedTest(name = "Sum, int로 변환이 불가능한 케이스 테스트. value={0}")
	@MethodSource("parameterForSumWithNullAndEmpty")
	void sumWithNullAndEmpty(String[] texts){
		assertThatExceptionOfType(NumberFormatException.class)
			.isThrownBy(()->NumberUtils.sumWithOutNegative(texts));
	}

	private static Stream<Arguments> parameterForSumWithNullAndEmpty(){
		return Stream.of(
			Arguments.of((Object) new String[]{"1", "", "3"}), 		// 빈값
			Arguments.of((Object) new String[]{"1", null, "3"}),	// null
			Arguments.of((Object) new String[]{"1", "$2", "3"}) 	// 숫자가 아닌 형태
						);
	}

	@Test
	@DisplayName("Sum, 음수가 포함된 케이스 테스트")
	void sumWithNagative(){
		// given
		String[] texts = {"1", "-2", "3"};

		// when
		assertThatExceptionOfType(LottoException.class)
			.isThrownBy(()->NumberUtils.sumWithOutNegative(texts))
			.withMessageContaining(NEGATIVE_TEXT.getMessage());
	}
}
