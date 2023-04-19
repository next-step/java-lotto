package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(StringCalculator.sum(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.difference(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        assertThat(StringCalculator.product(4, 2)).isEqualTo(8);
    }

    @Test
    void 나눗셈() {
        assertThat(StringCalculator.quotient(4, 2)).isEqualTo(2);
    }

    @Test
    void 나눗셈의_결과가_정수로_떨어지지_않으면_IllegalArgumentException을_던진다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> StringCalculator.quotient(3, 2))
            .withMessage("나눗셈의 결과가 정수로 떨어지지 않습니다.");
    }

    @ParameterizedTest
    @MethodSource("blankOrNullStrings")
    void 입력한값이_null이거나_공백문자일경우_IllegalArgumentException을_던진다(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> StringCalculator.calculate(input))
            .withMessage("잘못된 입력입니다.");
    }

    private static Stream<String> blankOrNullStrings() {
        return Stream.of("", null);
    }
}
