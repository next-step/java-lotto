package stringCalculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@DisplayName("입력한 문자열의 숫자와 연산기호에 맞게 계산해 결과를 반환한다")
	@Test
	void calculateStrings() {
		String input = "1 + 3 * 5 / 2";
		Calculator calculator = new Calculator();

		assertThat(calculator.calculate(input)).isEqualTo(10);
	}
}