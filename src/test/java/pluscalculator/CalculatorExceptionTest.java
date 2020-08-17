package pluscalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pluscalculator.argument.CalculatorArguments;
import pluscalculator.calculator.StringCalculator;

@DisplayName("입력값에 대한 예외 테스트")
public class CalculatorExceptionTest {

	@Test
	@DisplayName("입력값이 한개이고 음수일 때 테스트")
	public void minusNumberTest() {
		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("-4760")))
				.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("-23")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("음수는 입력하시면 안 됩니다.");
	}

	@Test
	@DisplayName("입력값이 기본 패턴이고 음수일 때 테스트")
	public void minusNumberTest2() {
		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("-19:2")))
				.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("-90:48")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("음수는 입력하시면 안 됩니다.");
	}

	@Test
	@DisplayName("입력값이 커스텀 패턴이고 음수일 때 테스트")
	public void minusNumberTest3() {
		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("//;\\n1;-2;3")))
				.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> StringCalculator.calculate(CalculatorArguments.from("//;\\n40;-243;89")))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("음수는 입력하시면 안 됩니다.");
	}
}
