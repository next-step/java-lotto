package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
	@DisplayName("식 받아서 숫자/기호 분리")
	void separateNumbers() {
		Calculator calculator = new Calculator("1 + 2 + 3");
		assertThat(calculator.getFormula()).isEqualTo(new String[] {"1", "+", "2", "+", "3"});
	}
}
