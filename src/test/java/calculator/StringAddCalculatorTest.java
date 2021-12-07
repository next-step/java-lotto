package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기")
public class StringAddCalculatorTest {
	@Test
	@DisplayName("null 또는 빈문자")
	public void splitAndSum_null_or_blank() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나 입력시")
	public void splitAndSum_one_number() throws Exception {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("쉼표 구분자 입력시")
	public void splitAndSum_comma_separator() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("쉼표 또는 콜론 구분자 입력시")
	public void splitAndSum_comma_or_colon() throws Exception {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("custom 구분자 입력시")
	public void splitAndSum_custom_separator() throws Exception {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("숫자 이외의 음수값을 전달할 경우, 예외처리 리턴")
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
