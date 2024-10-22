package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.IntBinaryOperator;

import static calculator.domain.Operation.findOperatorBySymbol;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class OperationTest {

    @ParameterizedTest
    @CsvSource({"+", "-", "*", "/"})
    void 사칙연산(String symbol) {
        assertThatNoException().isThrownBy(() -> findOperatorBySymbol(symbol));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 기호는_필수다(String symbol) {
        assertThatIllegalArgumentException().isThrownBy(() -> findOperatorBySymbol(symbol))
                .withMessage("기호를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"(", "^", "%", "1", "ㅁ", "a"})
    void 연산자는_사칙연산만_사용할_수_있다(String symbol) {
        assertThatIllegalArgumentException().isThrownBy(() -> findOperatorBySymbol(symbol))
                .withMessage("사용할 수 없는 연산자입니다. : " + symbol);
    }

    @ParameterizedTest
    @CsvSource({
            "+, 1,2,3",
            "-, 3,4,-1",
            "*, 5,6,30",
            "/, 7,8,0",
            "/, 10,5,2"
    })
    void 기호에_해당하는_연산을_수행한다(String symbol, int operand1, int operand2, int expected) {
        IntBinaryOperator function = findOperatorBySymbol(symbol);

        assertThat(function.applyAsInt(operand1, operand2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 100})
    void 제수로_0을_사용할_수_없다(int dividend) {
        IntBinaryOperator division = findOperatorBySymbol("/");
        final int ZERO_DIVISOR = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> division.applyAsInt(dividend, ZERO_DIVISOR))
                .withMessage("0으로 나눌 수 없습니다.");
    }
}