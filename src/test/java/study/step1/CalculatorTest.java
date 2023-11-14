package study.step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step1.domain.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step1.view.InputParser.parse;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
        "2 + 3 * 4 / 2",
        "50 / 5 * 2 / 2",
        "1 / 1 * 100 / 10",
        "1 - 1 + 100 / 10",
    })
    void 혼합(String string) {
        Calculator calculator = new Calculator(parse(string));
        assertThat(calculator.calculate()).isEqualTo(10);
    }

    @Test
    void 숫자_하나() {
        Calculator calculator = new Calculator(parse("1"));
        assertThat(calculator.calculate()).isEqualTo(1);
    }
}
