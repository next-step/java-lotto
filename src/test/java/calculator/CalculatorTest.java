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

	@Test
	void 더하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 + input2;

		int actual = sut.sum(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 뺴기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 - input2;

		int actual = sut.substact(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 곱하기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 * input2;

		int actual = sut.multiply(input1, input2);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 나누기() {
		int input1 = 10;
		int input2 = 2;
		int expected = input1 / input2;

		int actual = sut.divide(input1, input2);

		assertThat(actual).isEqualTo(expected);
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

}
