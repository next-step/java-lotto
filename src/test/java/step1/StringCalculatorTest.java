package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.controller.StringCalculator;
import step1.domain.Operators;


import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값_빈값_NULL_검증(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringCalculator.calculate(input);
                }).withMessageMatching("문자열이 빈값일 수 없습니다.");
    }


    @ParameterizedTest
    @ValueSource(strings = {"2 ^ 3 * 4 / 2", "2 + 3 % 4 / 2"})
    void 기티_연산자_검증(final String notArithmeticSymbol) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Operators(notArithmeticSymbol))
                .withMessage("'+,-,*,/'이외의 연산자는 사용할 수 없습니다.");
    }

}
