package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2|3", "1,2:3|6"}, delimiter = '|')
	void add_calculate(String inputParam, Integer resultParam) {
		Calculator calculator = new Calculator();
		Integer result = calculator.calculate(inputParam);
		assertThat(resultParam).isEqualTo(result);
	}

	@Test
	void check_null() {
		String input = "";
		Calculator calculator = new Calculator();
		Integer result = calculator.calculate(input);
		assertThat(result).isEqualTo(0);
	}
}
