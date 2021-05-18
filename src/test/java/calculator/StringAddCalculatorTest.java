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

	@Test
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
	public void splitAndSum_숫자하나() throws Exception {
		verifyResult("1", 1);
	}

	@Test
	@DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫나의 합을 반환한다.")
	public void splitAndSum_쉼표구분자() throws Exception {
		verifyResult("1,2", 3);
	}

	private void verifyResult(String input, int expected) {
		int result = StringAddCalculator.splitAndSum(input);
		assertThat(result).isEqualTo(expected);
	}

}
