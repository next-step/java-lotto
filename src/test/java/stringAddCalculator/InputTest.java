package stringAddCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
	@Test
	@DisplayName("빈 문자열 입력 시 0 반환")
	public void input_empty_string_return_0() {
		assertThat(new Input("")).isEqualTo(new Input("0"));
	}

	@Test
	@DisplayName("null 입력 시 0 반환")
	public void input_null_return_0() {
		assertThat(new Input(null)).isEqualTo(new Input("0"));
	}

	@Test
	@DisplayName("숫자 하나 입력 시 해당 수 반환")
	public void input_one_number_return_the_number() {
		assertThat(new Input("1")).isEqualTo(new Input("1"));
	}

	@Test
	@DisplayName("쉼표 혹은 콜론을 구분자로 가지는 문자열 전달 시 구분자 기준으로 분리한 숫자 배열 반환")
	public void input_string_contains_numbers_that_is_separated_by_comma_or_colon_return_sum() {
		assertThat(new Input("1,2").getStringNumbers()).containsExactly("1", "2");
		assertThat(new Input("1,2,3").getStringNumbers()).containsExactly("1", "2", "3");
		assertThat(new Input("1,2:3").getStringNumbers()).containsExactly("1", "2", "3");
	}

	@Test
	@DisplayName("커스텀 구분자 설정 시 커스텀 구분자로 자른 숫자 배열 반환")
	public void custom_delimiter_set_up() {
		assertThat(new Input("//;\n1;2;3").getStringNumbers()).containsExactly("1", "2", "3");
		assertThat(new Input("//:;\n2:;3:;4").getStringNumbers()).containsExactly("2", "3", "4");
	}
}

