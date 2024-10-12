package stringcalculator.service;

import org.junit.jupiter.api.Test;
import stringcalculator.model.Expression;
import stringcalculator.model.Number;
import stringcalculator.model.Operator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorServiceTest {

    @Test
    void 두_숫자_계산() {
        StringCalculatorService service = new StringCalculatorService();
        Number n1 = new Number(7);
        Number n2 = new Number(2);
        Operator op = Operator.PLUS;

        Number expected = service.calculateBasic(n1, n2, op);

        assertThat(expected.getNumber()).isEqualTo(9);
    }

    @Test
    void 여러_숫자_계산() {
        StringCalculatorService service = new StringCalculatorService();
        Expression expression = Expression.createExpression("1 + 2 + 3");

        Number expected = service.calculate(expression);

        assertThat(expected).isEqualTo(new Number(6));
    }

}
