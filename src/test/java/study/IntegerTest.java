package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IntegerTest {

	@DisplayName("parseInt() 메서드 예외 테스트")
	@ValueSource(strings = { "a", "1.2", "*" })
	@ParameterizedTest
	void test1(String input) {
		assertThatThrownBy(() -> Integer.parseInt(input)).isInstanceOf(IllegalArgumentException.class);
	}
}
