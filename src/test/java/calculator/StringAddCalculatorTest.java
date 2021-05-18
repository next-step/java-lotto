package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

	@Test
	@DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
	public void splitAndSum_null_또는_빈문자() {
		verifyResult(null, 0);

		verifyResult("", 0);
	}

	private void verifyResult(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}

}
