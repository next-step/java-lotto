package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ExceptionMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CalculatorControllerTest {
	private CalculatorController calculatorController;

	@BeforeEach
	public void setup() {
		calculatorController = new CalculatorController();
	}

	@Test
	public void 빈문자열_또는_null을_입력할_경우_0을_반환해야한다(){
		assertThat(calculatorController.validateInput("")).isTrue();
		assertThat(calculatorController.singleNumber("")).isEqualTo(0);

		assertThat(calculatorController.validateInput(null)).isTrue();
		assertThat(calculatorController.singleNumber(null)).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource (strings = {"-1", "-2", "-3"})
	public void 음수를_전달할경우_RuntimeException예외가_발생해야한다(String number){
		assertThatThrownBy(() -> calculatorController.splitNumber(number))
				.isInstanceOf(NumberFormatException.class)
				.hasMessage(ExceptionMessage.NUMBER_MINUS_EXCEPTION);
	}
}