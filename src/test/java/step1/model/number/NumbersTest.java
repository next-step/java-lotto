package step1.model.number;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
	private final Numbers numbers = new Numbers();

	@DisplayName("숫자로 변환 가능한 문자열 개수와 Numbers 개수는 같다")
	@Test
	void Given_numbers_Then_CreateNumbers() {
		List<String> strings = List.of(new String[] {"1", "2"});
		Numbers result = numbers.convertToNumbers(strings);
		assertThat(result).hasSize(strings.size());
	}
}