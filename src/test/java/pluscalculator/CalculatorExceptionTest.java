package pluscalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pluscalculator.calculator.StringCalculator;
import pluscalculator.util.InputAnalyzer;

@DisplayName("입력값에 대한 예외 테스트")
public class CalculatorExceptionTest {

	@Test
	@DisplayName("입력값이 한개이고 음수일 때 테스트")
	public void minusNumberTest() {
		assertThatThrownBy(() -> StringCalculator.calculate(InputAnalyzer.analyze("-3")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력값이 기본 패턴이고 음수일 때 테스트")
	public void minusNumberTest2() {
		assertThatThrownBy(() -> StringCalculator.calculate(InputAnalyzer.analyze("-3:2")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력값이 커스텀 패턴이고 음수일 때 테스트")
	public void minusNumberTest3() {
		assertThatThrownBy(() -> StringCalculator.calculate(InputAnalyzer.analyze("//;\n1;-2;3")))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
