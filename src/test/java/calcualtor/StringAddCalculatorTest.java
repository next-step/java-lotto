package calcualtor;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringAddCalculatorTest {
	@DisplayName("null 또는 빈문자일 경우 0 리턴")
	@ParameterizedTest
	@NullAndEmptySource
	public void splitAndSumNullOrEmpty(String input) {
		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자하나 입력시에 그대로 리턴")
	@RepeatedTest(value = 9, name = "input : {currentRepetition}")
	public void splitAndSumSingle(RepetitionInfo info) {
		// given
		int count = info.getCurrentRepetition();
		String input = String.valueOf(count);

		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(count);
	}

	@DisplayName("쉼표 구분자 계산 검증")
	@ParameterizedTest(name = "{index}. input : {0}, expected : {1}")
	@CsvSource(value = {
		"1,2=3",
		"2,3=5",
		"3,4=7",
		"4,5=9",
		"10,11=21"
	}, delimiter = '=')
	public void splitAndSumComma(String input, int expected) {
		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("쉼표 또는 콜론 구분자 계산 검증")
	@ParameterizedTest(name = "{index}. input : {0}, expected : {1}")
	@CsvSource(value = {
		"1,2:3=6",
		"2:3,4=9",
		"3,4,5=12",
		"4:5:11=20",
		"11:21,41,54=127"
	}, delimiter = '=')
	public void splitAndSumCommaOrColon(String input, int expected) {
		// when
		int result = StringAddCalculator.splitAndSum(input);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("커스텀 구분자 계산 검증")
	@Test
	public void splitAndSumCustomDelimiter() {
		// given
		String input1 = "//;\n1;2;3";
		String input2 = "//!\n11!22!33";

		// when
		int result1 = StringAddCalculator.splitAndSum(input1);
		int result2 = StringAddCalculator.splitAndSum(input2);

		// then
		assertAll(
			() -> assertThat(result1).isEqualTo(6),
			() -> assertThat(result2).isEqualTo(66)
		);
	}

	@DisplayName("음수를 입력할 경우 RuntimeException 발생 검증")
	@Test
	public void splitAndSumNegative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
