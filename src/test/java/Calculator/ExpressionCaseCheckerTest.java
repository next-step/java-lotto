package Calculator;


import Calculator.exception.WrongPlaceNumberOrOperatorException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExpressionCaseCheckerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1231233213 2 32132 2323", "* - + /", "* 10 - 20 *", "123 * 10 -"})
    public void func(String expression) {
        assertThrows(WrongPlaceNumberOrOperatorException.class, () -> {
            validateAndSplitExpression(expression);
        });
    }
}
