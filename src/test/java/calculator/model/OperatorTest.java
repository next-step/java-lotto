package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    @DisplayName("유효하지 않은 연산자 입력 시 에러 발생")
    public void 유효하지_않은_연산자_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.getBySymbol("%");
        });
        assertThatCode(() -> {
            Operator.getBySymbol("/");
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "0, 0, 0"})
    public void 덧셈(int left, int right, int expected) {
        Assertions.assertThat(Operator.ADD.calculate(left, right))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "3, 5, -2"})
    public void 뺄셈(int left, int right, int expected) {
        Assertions.assertThat(Operator.SUB.calculate(left, right))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 6", "-2, 3, -6", "2,  0, 0"})
    public void 곱셈(int left, int right, int expected) {
        Assertions.assertThat(Operator.MUL.calculate(left, right))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"4, 2, 2", "-2, 1, -2"})
    public void 나눗셈(int left, int right, int expected) {
        Assertions.assertThat(Operator.DIV.calculate(left, right))
                .isEqualTo(expected);
    }
}
