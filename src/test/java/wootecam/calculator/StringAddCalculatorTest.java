package wootecam.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringAddCalculatorTest {
	@Test
	void splitAndSum_null_또는_빈문자() {

	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3_6", "1:6,3_10", "20:2:3_25"}, delimiter = '_')
	@DisplayName("기본 구분자로 구성된 입력에대해 문자열 계산기능 테스트")
	void splitAndSum_기본구분자사용(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertEquals(expected, result);
	}

	@ParameterizedTest
	@CsvSource(value = {"//;\\n1;2;3=6", "//:\\n1:2:3=6"}, delimiter = '=')
	@DisplayName("기본 구분자로 구성된 입력에대해 문자열 계산기능 테스트")
	void splitAndSum_커스텀구분자사용(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertEquals(expected, result);
	}
}
