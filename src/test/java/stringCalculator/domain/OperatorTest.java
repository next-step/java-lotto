package stringCalculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.domain.Operator;

class OperatorTest {

	@DisplayName("문자열로 연산기호를 받았을 때 연산기호에 맞는 연산결과를 보여준다")
	@Test
	void operator() {
		int num1 = 5;
		int num2 = 3;

		assertThat(Operator.PLUS.calculate(num1, num2)).isEqualTo(8);
		assertThat(Operator.MINUS.calculate(num1,num2)).isEqualTo(2);
		assertThat(Operator.MULTIPLY.calculate(num1,num2)).isEqualTo(15);
		assertThat(Operator.DIVIDE.calculate(num1,num2)).isEqualTo(1);
	}
}