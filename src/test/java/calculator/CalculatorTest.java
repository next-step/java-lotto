package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorTest {

	private Calculator sut;

	@BeforeEach
	void setUp() {
		sut = new Calculator();
	}

	@ParameterizedTest
	@NullAndEmptySource
	void null_또는_공백문자_입력_시_IllegalArgumentException를_던진다(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(input);
		});
	}

	@Test
	void 미완성_계산식을_입력할_경우_IllegalArgumentException를_던진다() {
		String incompleteFormula = "1 + ";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(incompleteFormula);
		});
	}

	@Test
	void 완전한_계산식에서_숫자가_아닌_값이_입력될_경우_IllegalArgumentException를_던진다() {
		String invalidFormula = "a + 10";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(invalidFormula);
		});
	}

	@Test
	void 완전한_계산식에서_사칙연산자가_아닌_값이_입력될_경우_IllegalArgumentException를_던진다() {
		String invalidFormula = "20 @ 10";

		assertThatIllegalArgumentException().isThrownBy(() -> {
			int result = sut.calculate(invalidFormula);
		});
	}

	@Test
	void calculate는_문자열_계산식을_입력하면_계산된_결과를_반환한다() {
		String validFormula = "21 + 2 - 3 * 4 / 5";
		int expected = 16;

		int actual = sut.calculate(validFormula);

		assertThat(actual).isEqualTo(expected);
	}

}
