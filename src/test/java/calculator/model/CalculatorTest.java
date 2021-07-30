package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private static final String PATTERN_REG_EXP = "^//(.)\n(.*)$";

	@Test
	@DisplayName("계산기의 문자열이 빈값이면 예외가 발생된다.")
	public void validStringEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () -> Calculator.createCalculator("")
		);
	}

	@Test
	@DisplayName("문자열을 입력하는 패턴에 따라 분리한다.")
	public void stringToSplit() {
		Calculator calculator = Calculator.createCalculator("11");

		String[] result = calculator.stringToSplit(",", "1,2,3");

		assertThat(result).containsExactly("1", "2", "3");
	}

	@Test
	@DisplayName("문자열을 입력하는 패턴에 따라 분리한다.")
	public void patternResult() {
		Calculator calculator = Calculator.createCalculator("1:2:3");

		String[] result = calculator.patternResult(PATTERN_REG_EXP, "1,2,3");

		assertThat(result).containsExactly("1", "2", "3");

		String[] result2 = calculator.patternResult(PATTERN_REG_EXP, "//,\n1,2,3");

		assertThat(result2).containsExactly("1", "2", "3");
	}

	@Test
	@DisplayName("계산기의 문자열에 따라 덧셈 계산기에 의하여 계산된 값이 반환된다.")
	public void plusCalculator() {
		Calculator calculator = Calculator.createCalculator("//:\n1:2:3:4");
		int result1 = calculator.calculate();

		assertThat(result1).isEqualTo(10);

		Calculator calculator2 = Calculator.createCalculator("1:2:3,4,5");
		int result2 = calculator2.calculate();

		assertThat(result2).isEqualTo(15);

	}

}