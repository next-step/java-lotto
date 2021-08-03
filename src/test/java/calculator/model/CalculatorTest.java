package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	@DisplayName("계산기의 문자열이 빈값이면 예외가 발생된다.")
	public void validStringEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () -> new Calculator().createCharacters("")
		);
	}

	@Test
	@DisplayName("계산기의 문자열에 따라 덧셈 계산기에 의하여 계산된 값이 반환된다.")
	public void plusCalculator() {
		Calculator calculator = new Calculator();
		Characters characters1 = calculator.createCharacters("//:\n1:2:3:4");
		int result1 = calculator.calculate(characters1);

		assertThat(result1).isEqualTo(10);

		Calculator calculator2 = new Calculator();
		Characters characters2 = calculator.createCharacters("1:2:3,4,5");
		int result2 = calculator2.calculate(characters2);

		assertThat(result2).isEqualTo(15);

	}

}