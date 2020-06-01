package study1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringsplitCalculatorTest {

	@NullAndEmptySource
	@DisplayName("input값이 null or 공백인 경우")
	public void splitAndSum_null_또는_빈문자(String input) {

		assertThatThrownBy(() -> Splitter.split(null)).isInstanceOf(NullPointerException.class);

		assertThatThrownBy(() -> Splitter.split("")).isInstanceOf(IllegalArgumentException.class);
		assertTrue(Strings.isBlank(input));
	}

	@Test
	@DisplayName("input값이 숫자하나만 입력받은 경우")
	public void splitAndSum_숫자하나() throws Exception {
		int result = Calculator.calculator("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = Calculator.calculator("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("기본 split 결과")
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = Calculator.calculator("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("custom split 결과")
	public void splitAndSum_custom_구분자() throws Exception {
		int result = Calculator.calculator("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("음수값이 포함되었을 때")
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> Validator.negativeCheck(Splitter.split("-1,2,3")))
				.isInstanceOf(RuntimeException.class);
	}
}
