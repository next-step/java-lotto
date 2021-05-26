package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

	@ParameterizedTest(name = "splitAndSum 기능 테스트. text={0}, expected={1}")
	@CsvSource(value = {
		"$0", "''$0", "1$1", "1,2$3", "1,2:3$6"
	}, delimiter = '$')
	public void splitAndSum_null_또는_빈문자(String text, int expected) {
		int result = StringAddCalculator.splitAndSum(text);
		assertThat(result).isEqualTo(expected);
	}

	@Test
	public void splitAndSum_custom_구분자() {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
