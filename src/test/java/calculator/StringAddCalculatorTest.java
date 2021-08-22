package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {
    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈값테스트(String input) {
        int expected = 0;
        int actual = stringAddCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2', 3",
            "'1,2,3', 6",
            "'1,3:5', 9"
    })
    void 쉼표_콜론_테스트(String input, int expected) {
        int actual = stringAddCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\\n1;2;3', 6",
            "'//|\\n1|4|8', 13"
    })
    void 커스텀_구분자_테스트(String input, int expected) {
        int actual = stringAddCalculator.calculate(input);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            " , '숫자 이외의 값'",
            "-1, '음수'",
            "'//;\\n1;-2;3', '음수'",
            "'1,2,,3', '숫자 이외의 값'",
            "a, '숫자 이외의 값'"
    })
    void 예외_테스트(String input, String expected) {
        assertThatThrownBy(() -> stringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(expected);
    }
}