package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	@DisplayName("수식은 null일 수 없다")
	void expression_is_not_null() {
		assertThatThrownBy(() -> new Calculator(null)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("수식은 공백을 포함할 수 없다")
	void expression_is_not_containing_blank() {
		List<String> expressions = List.of(" ", "  ");
		assertThatThrownBy(() -> new Calculator(expressions)).isInstanceOf(IllegalArgumentException.class);
	}
}
