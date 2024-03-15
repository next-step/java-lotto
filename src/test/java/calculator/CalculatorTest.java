package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @ParameterizedTest
    @DisplayName("사칙연산 계산 기능을 테스트")
    @CsvSource(value = {"2 + 3=5","3 - 5=-2","3 * 5=15","6 / 5=1", "2 + 3 - 5 = 0"}, delimiter = '=')
    public void calculatorLogicTest(String input, int output) {
        int result = CalculatorLogic.calculatorLogic(input);
        assertThat(result).isEqualTo(output);
    }

    @Test
    @DisplayName("사칙연산 기호 찾는 기능 테스트")
    public void findSymbolTest() {
        Arrays.stream(Calculator.values()).forEach(calculator -> {
            String symbol = Calculator.findSymbol(calculator.getSymbol()).getSymbol();
            System.out.println(symbol);
            assertThat(symbol).isEqualTo(calculator.getSymbol());
        });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닐 때 에러 테스트")
    public void findSymbolErrorTest() {
        assertThatThrownBy(() -> Calculator.findSymbol("!").getSymbol())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산");
    }

}
