package calculator.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {


	@Test
	@DisplayName("계산기의 문자열이 빈값이면 예외가 발생된다.")
	public void validStringEmptyCheck() {
		assertThrows(IllegalArgumentException.class, () -> Calculator.createCalculator("")
		);
	}

	@Test
	@DisplayName("문자열에 '//' 값이 있으면 true, 없으면 false 를 반환한다.")
	public void specialStringExistCheck() {
		Calculator calculator = Calculator.createCalculator("nextstep");
		boolean result = calculator.getSpecialTextExist("//");

		assertThat(result).isFalse();

		Calculator calculator2 = Calculator.createCalculator("//nextstep");
		boolean result2 = calculator2.getSpecialTextExist("//");

		assertThat(result2).isTrue();
	}

	@Test
	@DisplayName("문자열에 '\n' 값이 있으면 true, 없으면 false 를 반환한다.")
	public void specialTextExistCheck() {
		Calculator calculator = Calculator.createCalculator("nextstep");
		boolean result = calculator.getSpecialTextExist("//");

		assertThat(result).isFalse();

		Calculator calculator2 = Calculator.createCalculator("\nnextstep");
		boolean result2 = calculator2.getSpecialTextExist("\n");

		assertThat(result2).isTrue();
	}

	@Test
	@DisplayName("문자열에 '// \n' 값이 있으면 true, 없으면 false 를 반환한다.")
	public void specialTextNotingOrExistCheck() {
		Calculator calculator = Calculator.createCalculator("nextstep");
		boolean result = calculator.getAllSpecialTextExist();

		assertThat(result).isFalse();

		Calculator calculator2 = Calculator.createCalculator("//:\n nextstep");
		boolean result2 = calculator2.getAllSpecialTextExist();

		assertThat(result2).isTrue();
	}

}