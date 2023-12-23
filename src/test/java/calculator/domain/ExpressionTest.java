package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
	@DisplayName("두 숫자를 더하여 값을 리턴한다.")
	@Test
	void 식을_분리한다() {
		String input = "1 + 2";
		Expression expression = new Expression(input);
		Digit expectingResult = new Digit(1);

		assertThat(expression.numbers().contains(expectingResult)).isTrue();
	}

	@DisplayName("사칙연산 기호가 아닌 경우 에러.")
	@Test
	void 사칙연산_기호가_아닌_문자가_들어왔다() {
		String input = "4 * 2 * 3 ^ 4 / 3";

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Expression expression = new Expression(input);
			}).withMessage("사칙 연산 기호가 아닙니다.");
	}

	@DisplayName("연속된 공백 입력")
	@Test
	void 연속된_공백_입력() {
		String input = "4 *   * 3 - 4 / 3";

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Expression expression = new Expression(input);
			}).withMessage("연속된 공백이 입력되었습니다.");
	}

	@DisplayName("공백이 없는 경우 에러")
	@Test
	void 공백이_없는_경우_에러를_던진다() {
		String input = "4*3-4/3";

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Expression expression = new Expression(input);
			}).withMessage("공백을 사이에 두고 숫자나 기호를 입력하세요.");
	}
}
