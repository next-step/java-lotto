package calculator;

import calculator.model.Formula;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringCalculatorTest {

    @Test
    void 덧셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 + 3"));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(5);
    }

    @Test
    void 뺄셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("8 - 3"));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(5);
    }

    @Test
    void 곱셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 * 3"));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(6);
    }

    @Test
    void 나눗셈을_할_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("6 / 3"));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("계산을_성공_매개변수")
    void 계산을_성공했을떄(String formula, int resultValue) {
        StringCalculator stringCalculator = new StringCalculator(new Formula(formula));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(resultValue);
    }

    static Stream<Arguments> 계산을_성공_매개변수() {
        return Stream.of(
                arguments("2 + 3 * 4 / 2", 10),
                arguments("2 / 1 * 4 + 2", 10),
                arguments("2 + 5 * 4 / 2", 14)
        );
    }

    @Test
    void 계산_값이_0이_될_경우() {
        StringCalculator stringCalculator = new StringCalculator(new Formula("2 * 0"));
        assertThat(stringCalculator.calculate().getNumber()).isEqualTo(0);
    }

}
