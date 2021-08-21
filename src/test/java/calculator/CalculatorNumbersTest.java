package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class CalculatorNumbersTest {

	@Test
	void plus() {
		CalculatorNumbers numbers = new CalculatorNumbers(Arrays.asList("1", "2", "3"));

		assertThat(numbers.sumAll()).isEqualTo(new CalculatorNumber(6));
	}
}
