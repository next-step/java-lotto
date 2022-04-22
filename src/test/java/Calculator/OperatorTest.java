package Calculator;

import Calculator.exception.WrongPlaceNumberOrOperatorException;
import Calculator.exception.OnlyNumberException;
import Calculator.exception.OnlyOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import static Calculator.ExpressionPreWorker.validateAndSplitExpression;

public class OperatorTest {

    @Test
    @DisplayName("null 또는 빈 문자열일 경우 예외처리 테스트")
    public void validateTest() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            validateAndSplitExpression(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            validateAndSplitExpression("");
        });
    }

    @Test
    @DisplayName("공백 문자열이 있으면 split 으로 문자를 나누는 테스트")
    public void splitTest() {
        assertArrayEquals(validateAndSplitExpression("1 * 3"), new String[]{"1", "*", "3"});
        assertArrayEquals(validateAndSplitExpression("1 * 3 - 100"), new String[]{"1", "*", "3", "-", "100"});
    }

    @Test
    @DisplayName("숫자만 있는 경우 예외 처리")
    public void onlyNumberTest() {
        Exception exception = assertThrows(OnlyNumberException.class, () -> {
            validateAndSplitExpression("1231233213 2 32132 2323");
        });

        assertEquals(exception.getClass(), OnlyNumberException.class);
    }

    @Test
    @DisplayName("연산자만 있는 경우 예외 처리")
    public void onlyOperatorTest() {
        Exception exception = assertThrows(OnlyOperatorException.class, () -> {
            validateAndSplitExpression("* - + /");
        });

        assertEquals(exception.getClass(), OnlyOperatorException.class);
    }

    @Test
    @DisplayName("계산 가능한 식인지 테스트(1. 홀수자리는 피연산자, 짝수자리는 연산자)")
    public void possibleCompute1ExpTest() {
        Exception exception = assertThrows(WrongPlaceNumberOrOperatorException.class, () -> {
            validateAndSplitExpression("* 10 - 20 *");
        });

        assertEquals(exception.getClass(), WrongPlaceNumberOrOperatorException.class);
    }

    @Test
    @DisplayName("계산 가능한 식인지 테스트(2. 피연산자와 연산자의 갯수의 합은 무조건 홀수다)")
    public void possibleCompute2ExpTest() {
        Exception exception = assertThrows(WrongPlaceNumberOrOperatorException.class, () -> {
            validateAndSplitExpression("123 * 10 -");
        });

        assertEquals(exception.getClass(), WrongPlaceNumberOrOperatorException.class);
    }

    @Test
    @DisplayName("덧셈 계산테스트")
    public void sumTest() {
        assertEquals(Calculator.compute(new String[]{"10", "+", "20"}), 30);
    }

    @Test
    @DisplayName("뺼셈 계산테스트")
    public void subtractTest() {
        assertEquals(Calculator.compute(new String[]{"30", "-", "20"}), 10);
        assertEquals(Calculator.compute(new String[]{"20", "-", "30"}), -10);
    }

    @Test
    @DisplayName("곱셈 계산테스트")
    public void multiplyTest() {
        assertEquals(Calculator.compute(new String[]{"10", "*", "20"}), 200);
    }

    @Test
    @DisplayName("나눗셈 계산테스트")
    public void divideTest() {
        assertEquals(Calculator.compute(new String[]{"20", "/", "10"}), 2);
        assertEquals(Calculator.compute(new String[]{"10", "/", "20"}), 0);
    }

    @Test
    @DisplayName("혼합 연산 테스트")
    public void allOperatorTest() {
        assertEquals(Calculator.compute(new String[]{"20", "+", "10", "-", "20", "*", "5"}), 50);
        assertEquals(Calculator.compute(new String[]{"1", "/", "5", "+", "10", "/", "1"}), 10);
        assertEquals(Calculator.compute(new String[]{"1", "*", "10", "-", "5", "/", "1"}), 5);
        assertEquals(Calculator.compute(new String[]{"1", "/", "5", "/", "5", "/", "1"}), 0);
    }

    @Test
    @DisplayName("계산기 통합 테스트")
    public void calcTest() {
        assertEquals(Calculator.executeCalc("1 + 2 + 3 + 4 + 5"), 15);
        assertEquals(Calculator.executeCalc("1 / 2 / 3 / 4 / 5"), 0);
        assertEquals(Calculator.executeCalc("1 * 100 - 100 + 100 / 100"), 1);
        assertEquals(Calculator.executeCalc("100 - 50 + 50 * 2"), 200);
    }
}
