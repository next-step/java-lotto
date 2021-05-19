package wootecam.calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringAddCaculatorTest {
	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3_6", "1:6,3_10", "20:2:3_25"}, delimiter = '_')
	@DisplayName("기본 구분자로 구성된 입력에대해 문자열 계산기능 테스트")
	public void splitAndSum_기본구분자사용(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertEquals(expected, result);
	}
}
