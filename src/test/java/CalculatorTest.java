import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.NotFoundOperatorException;
import model.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	@DisplayName("사칙연산 연산자 유무 판별")
	void 연산자_테스트() {
		Calculator calculator = new Calculator();

		assertThat(calculator.isOperator("+")).isEqualTo("+");
	}

	@Test
	@DisplayName("사칙연산 연산자 유무 예외 처리")
	void 연산자_예외_테스트() {
		Calculator calculator = new Calculator();

		assertThatThrownBy(() -> calculator.isOperator("+")).isInstanceOf(
			NotFoundOperatorException.class);
	}

	@Test
	@DisplayName("계산 테스트")
	void 문자열_계산테스트(){
		Calculator calculator = new Calculator();

		assertThat(calculator.getResult("3 + 2 * 5")).isEqualTo(30);
	}
}
