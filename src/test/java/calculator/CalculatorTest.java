package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator sut;

	@BeforeEach
	void setUp() {
		sut = new Calculator();
	}

	@Test
	void 완전한_계산식에서_숫자가_아닌_값이_입력될_경우_IllegalArgumentException를_던진다() {
		String invalidFormula = "a + 10";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(new Formula(invalidFormula));
		});
	}

	@Test
	void 완전한_계산식에서_사칙연산자가_아닌_값이_입력될_경우_IllegalArgumentException를_던진다() {
		String invalidFormula = "20 @ 10";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(new Formula(invalidFormula));
		});
	}

	@Test
	void calculate는_문자열_계산식을_입력하면_계산된_결과를_반환한다() {
		String validFormula = "21 + 2 - 3 * 4 / 5";
		int expected = 16;

		int actual = sut.calculate(new Formula(validFormula));

		assertThat(actual).isEqualTo(expected);
	}

}
