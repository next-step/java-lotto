package stringAddCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
	@Test
	@DisplayName("숫자 외의 값이 입력 되었을 경우 런타임 에러 발생")
	public void input_something_that_is_not_number_return_runtime_exception() {
		assertThatThrownBy(() -> new Number("a"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("0 이하, 1000만 이상의 값이 입력되면 에러 발생")
	public void input_contains_negative_or_few_numbers_that_are_over_one_million_return_runtime_exception() {
		assertThatThrownBy(() -> new Number("-1"))
			.isInstanceOf(RuntimeException.class);
		assertThatThrownBy(() -> new Number("100000000"))
			.isInstanceOf(RuntimeException.class);
	}
}
