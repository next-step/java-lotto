package stringAddCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {
	@Test
	@DisplayName("100개 이상의 값이 입력되면 에러 발생")
	public void input_contains_numbers_that_count_over_one_hundred_return_runtime_exception() {
		String[] numbersOver100 = new String[101];
		for (int i = 0; i < 101; i++) {
			numbersOver100[i] = "100";
		}

		assertThatThrownBy(() -> new Numbers(numbersOver100))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	@DisplayName("값 배열을 전달하면 합을 리턴")
	public void convey_value_array_return_sum() {
		String[] valueArray = {"1", "2", "3"};
		assertThat(new Numbers(valueArray).getSum()).isEqualTo(6);
	}
}
