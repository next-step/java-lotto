package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class SeperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void 입력값_분리(String input) {
        Seperator seperator = new Seperator();
        String[] split = seperator.split(input);

        assertThat(split[0]).isEqualTo("2");
        assertThat(split[1]).isEqualTo("+");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void null_또는_blank_체크(String input) {
        Seperator seperator = new Seperator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    seperator.split(input);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void 사칙연산_기호_구분(String operator) {
        Seperator seperator = new Seperator();
        boolean result = seperator.isOperator(operator);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"&", "@", "%"})
    void 기호_예외_발생(String input) {
        Seperator seperator = new Seperator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    seperator.isOperator(input);
                });
    }
}