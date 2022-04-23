package Calculator;

import Calculator.exception.OnlyNumberException;
import Calculator.exception.OnlyOperatorException;
import Calculator.exception.WrongPlaceNumberOrOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpressionCaseCheckerTest {

    @Test
    @DisplayName("수식에 피연산자만 있는 경우 예외를 던진다")
    public void onlyNumberTest() {
        assertThrows(OnlyNumberException.class, () -> {
            validateAndSplitExpression("1231233213 2 32132 2323");
        });
    }

    @Test
    @DisplayName("수식에 연산자만 있는 경우 예외를 던진다")
    public void onlyOperatorTest() {
        assertThrows(OnlyOperatorException.class, () -> {
            validateAndSplitExpression("* - + /");
        });
    }

    @Test
    @DisplayName(" '홀수자리는 피연산자, 짝수자리는 연산자' 라는 규칙을 지키지 않으면 예외를 던진다. ")
    public void possibleCompute1ExpTest() {
        assertThrows(WrongPlaceNumberOrOperatorException.class, () -> {
            validateAndSplitExpression("* 10 - 20 *");
        });
    }

    @Test
    @DisplayName(" '피연산자와 연산자의 갯수의 합은 무조건 홀수다' 라는 규칙을 지키지 않으면 예외를 던진다. ")
    public void possibleCompute2ExpTest() {
        assertThrows(WrongPlaceNumberOrOperatorException.class, () -> {
            validateAndSplitExpression("123 * 10 -");
        });
    }
}
