package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionTest {

	private Expression expression;

	@Test
	@DisplayName("수식: 유저 수식 추가 문자열 분리 및 계산 테스트")
	void mixExpressionCalculateTest() {

		expression = new Expression("//;\n1;2:3;4:5;6,7,8;9");

		assertThat(expression.sum()).isEqualTo(45);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3#6", "1:2:3:4#10", "1,2:3,4:5:6#21"}, delimiter = '#')
	@DisplayName("수식: 구분자 `,` `:` 문자열 분리 및 계산 테스트")
	void expressionCalculateTest(String userInput, int result) {

		expression = new Expression(userInput);

		assertThat(expression.sum()).isEqualTo(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6"})
	@DisplayName("수식: 유저 숫자 하나 입력 및 계산 테스트")
	void initOneNumberTest(String inputStr) {
		expression = new Expression(inputStr);

		assertThat(expression.sum()).isEqualTo(Integer.parseInt(inputStr));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\n1;2:3;4:5;6,7,8;9"})
	@DisplayName("수식: 유저 입력 수식 객체 생성 테스트")
	void initExpressionTest(String inputExpression) {

		expression = new Expression(inputExpression);

		assertThat(expression).isEqualTo(new Expression(inputExpression));
	}

	@Test
	@DisplayName("수식: null 이나 빈값 객체 생성 테스트")
	void initEmptyExceptionTest() {

		assertThatIllegalArgumentException().isThrownBy(() -> new Expression(null));
		assertThatIllegalArgumentException().isThrownBy(() -> new Expression(""));

	}
}
