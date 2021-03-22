package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculationTest {
	Calculator calculator = new Calculator();
	InputSplit inputSplit;

	@DisplayName("입력값 Null 및 공백 반환값 테스트")
	@ParameterizedTest
	@CsvSource(value = {",0", "'',0", "' ',0"})
	void splitTest_Null_or_Empty(String input, String expected) {
		inputSplit = new InputSplit(input);
		assertThat(inputSplit.split()).contains(expected);
	}

	@Test
	@DisplayName("입력값 구분자 자르기 테스트")
	void splitTest_구분자() {
		inputSplit = new InputSplit("1,2");
		assertThat(inputSplit.split()).contains("1", "2");

		inputSplit = new InputSplit("1,2,3");
		assertThat(inputSplit.split()).contains("1", "2", "3");

		inputSplit = new InputSplit("1,2:3");
		assertThat(inputSplit.split()).contains("1", "2", "3");
	}

	@Test
	@DisplayName("입력값 커스텀 구분자 자르기 테스트")
	void splitTest_커스텀구분자() {
		inputSplit = new InputSplit("//;\n1;2");
		assertThat(inputSplit.split()).contains("1", "2");

		inputSplit = new InputSplit("//;\n1;2;3");
		assertThat(inputSplit.split()).contains("1", "2", "3");

		inputSplit = new InputSplit("//w\n1w2w3");
		assertThat(inputSplit.split()).contains("1", "2", "3");
	}

	@DisplayName("덧셈 테스트자: 표준 구분자")
	@ParameterizedTest
	@CsvSource(value = {"''|0", "1,2|3", "1,2:3|6", "5|5"}, delimiter = '|')
	void calculatorTest(String input, int expected) {
		assertThat(calculator.run(input)).isEqualTo(expected);
	}

	@Test
	@DisplayName("덧셈 테스트: 커스텀 구분자")
	void calculatorTest_customDelimiter() {
		assertThat(calculator.run("//;\n1;2;3")).isEqualTo(6);
		assertThat(calculator.run("//x\n1x2x3x10")).isEqualTo(16);
	}

	@Test
	@DisplayName("덧셈 테스트: 숫자 이외의 값 또는 음수 전달")
	void calculatorTest_not_positive() {
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				calculator.run("//;\n-1;2;3");
				calculator.run("//x\n1xwx3x10");
			});
	}
}
