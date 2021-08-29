package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
	@DisplayName(value = "로또 번호의 유효 범위를 벗어나면 예외를 던짐")
	@ValueSource(ints = {-1, 0, 46})
	@ParameterizedTest
	void notBetweenOneAndFortyFive(int value) {
		assertThatThrownBy(() -> new Number(value))
			.isInstanceOf(RuntimeException.class);
	}
}
