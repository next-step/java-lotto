package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTest {

    @DisplayName("사칙 연산자 아닌경우")
    @ParameterizedTest
    @ValueSource(strings = {"^", "%", "!"})
    void 사칙연산_기호가_아닌_경우(String symbol) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(symbol))
                .withMessageMatching("해당 연산자는 사칙연사자가 아닙니다.");
    }

    @DisplayName("사칙 연산자 확인")
    @Test
    void 사칙연산_기호일_경우() {
        assertTrue(Operator.PLUS.equals(Operator.of("+")));
        assertTrue(Operator.MINUS.equals(Operator.of("-")));
        assertTrue(Operator.MULTIPLY.equals(Operator.of("*")));
        assertTrue(Operator.DIVIDE.equals(Operator.of("/")));
    }
}
