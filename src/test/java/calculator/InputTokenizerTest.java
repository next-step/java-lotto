package calculator;

import calculator.type.OperatorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputTokenizerTest {

    @DisplayName("입력값이 null 또는 빈 문자열인 경우 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void create(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new InputTokenizer(input));
    }

    @DisplayName("숫자만 분리")
    @Test
    void splitNumber() {
        InputTokenizer inputTokenizer = new InputTokenizer("1 + 2 + 3 / 4 * 5");
        assertThat(inputTokenizer.numbers()).containsExactly(1, 2, 3, 4, 5);
    }

    @DisplayName("연산자만 분리")
    @Test
    void splitOperator() {
        InputTokenizer inputTokenizer = new InputTokenizer("1 + 2 + 3 / 4 * 5");
        assertThat(inputTokenizer.operators()).containsExactly(OperatorType.ADD, OperatorType.ADD, OperatorType.DIVIDE, OperatorType.MULTIPLY);
    }
}