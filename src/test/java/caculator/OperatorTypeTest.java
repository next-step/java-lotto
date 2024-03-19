package caculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class OperatorTypeTest {

    @Test
    @DisplayName("두인자의 값을 더한다")
    void plusMethodTest() {
        assertThat(OperatorType.PLUS.apply(new Number(4), new Number(5)))
                .isEqualTo(new Number(9));
    }

    @Test
    @DisplayName("두 인자의 값을 뺀다")
    void minus() {
        assertThat(OperatorType.MINUS.apply(new Number(2), new Number(5)))
                .isEqualTo(new Number(-3));
    }

    @Test
    @DisplayName("두 인자의 값을 나누고, 결과값은 정수여야한다.")
    void divide() {
        assertThat(OperatorType.DIVIDE.apply(new Number(7),new Number(5)))
                .isEqualTo(new Number(1));

    }

    @Test
    @DisplayName("두 연산자의 값을 곱한다.")
    void multiple() {
        assertThat(OperatorType.MULTIPLE.apply(new Number(5), new Number(2)))
                .isEqualTo(new Number(10));
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "&"})
    @DisplayName("알맞지 않은 연산자는 Exception을 반환한다.")
    void operatorTypeTest(String text){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    OperatorType.findByValue(text);
                });
    }
}
