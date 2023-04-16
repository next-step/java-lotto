package calculator.domain;

import calculator.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    @DisplayName("계산기 객체 생성 테스트")
    void createCalculator() {
        Expression expression = Expression.createExpression("1 + 2".split(InputView.DELIMITER));
        StringCalculator stringCalculator = new StringCalculator(expression);

        assertThat(stringCalculator).usingRecursiveComparison()
                .isEqualTo(expression.getSize());
    }

    @Test
    @DisplayName("계산 결과 테스트")
    void calculateResultTest() {
        Expression expression = Expression.createExpression("2 + 3 * 4 / 2".split(InputView.DELIMITER));
        StringCalculator stringCalculator = new StringCalculator(expression);

        int result = stringCalculator.calculate();

        assertThat(result).isEqualTo(10);
    }
}