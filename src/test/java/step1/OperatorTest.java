package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static step1.Operator.*;

public class OperatorTest {

    @Test
    void 덧셈_테스트() {
        int a = 5, b = 6;
        Integer calculate = PLUS.calculate(a, b);
        Assertions.assertThat(calculate).isEqualTo(a + b);
    }

    @Test
    void 뺄셈_테스트() {
        int a = 6, b = 5;
        Assertions.assertThat(SUBTRACT.calculate(a, b)).isEqualTo(a - b);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트() {
        int a = 6, b = 5;
        Assertions.assertThat(MULTIPLE.calculate(a, b)).isEqualTo(a * b);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트() {
        int a = 6, b = 2;
        Assertions.assertThat(DIVIDE.calculate(a, b)).isEqualTo(a / b);
    }

}
