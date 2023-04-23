package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 입력한값이_null이거나_공백문자일경우_IllegalArgumentException을_던진다(String input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Expression(input))
            .withMessage("잘못된 입력입니다.");
    }
}