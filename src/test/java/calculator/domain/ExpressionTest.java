package calculator.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class ExpressionTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 공백_또는_null을_사용할_수_없다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(input))
                .withMessageContaining("수식을 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1*1", "1 -", "0 +- 3", "1 + 가 - 9"})
    void 형식에_맞는_문자열만_사용할_수_있다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(input))
                .withMessageContaining("올바르지 않은 수식입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-10 + 5", "20 + -10"})
    void 음수를_사용할_수_있다(String input) {
        assertThatNoException().isThrownBy(() -> new Expression(input));
    }
}