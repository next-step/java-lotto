package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

public class InOrderCalculatorTest {

    @Test
    @DisplayName("입력된 수식이 3개 미만인 경우 예외 발생")
    void calculate() {
        CalculateStrategy calculateStrategy = new InOrderCalculator();
        List<String> tokens = List.of("2", "+");
        Assertions.assertThatThrownBy(() -> calculateStrategy.calculate(tokens))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 수식이 짝수인 경우 예외 발생")
    void calculate2() {
        CalculateStrategy calculateStrategy = new InOrderCalculator();
        List<String> tokens = List.of("2", "+", "3", "+");
        Assertions.assertThatThrownBy(() -> calculateStrategy.calculate(tokens))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("순서대로 계산 되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 2:10", "3 - 2 / 2:0.5", "2 * 3 + 3 / 3:3", "2 / 4 + 3 * 2:7"}, delimiter = ':')
    void calculate3(String input, String expected) {
        CalculateStrategy calculateStrategy = new InOrderCalculator();
        List<String> tokens = Tokenizer.tokenize(input);
        Assertions.assertThat(calculateStrategy.calculate(tokens)).isEqualByComparingTo(new BigDecimal(expected));
    }

}
