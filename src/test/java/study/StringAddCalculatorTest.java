package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

	@DisplayName("null 또는 빈문자가 들어왔을때 0이 반환되는지 테스트")
	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자 하나의 문자열을 인자로 전달했을때 그대로 리턴되는지 테스트")
	@Test
	public void splitAndSum_숫자하나() {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName("쉼표를 구분자로 숫자를 나누고 두 숫자의 합을 반환하는지 테스트")
	@Test
	public void splitAndSum_쉼표구분자() {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("구분자를 컴마(,) 이외에 콜론(:) 을 사용할 수 있는지 테스트")
	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있는지 테스트")
	@Test
	public void splitAndSum_custom_구분자() {
		int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생하는지 테스트")
	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

}
