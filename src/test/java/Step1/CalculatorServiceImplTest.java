package Step1;

import Step1.intefaces.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceImplTest {

    private static CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @CsvSource(value = {"1 + 1=2", "1 + 4 - 3=2", "1 - 1 + 5 * 10=50", "1 + 2 * 3 - 3 / 2=3", "1 * 2 + 8 / 5=2"}, delimiter = '=')
    void 문자열을_입력_시_사칙연산_수행_후_결과값_응답(String input, String answer) {
        assertThat(calculatorService.calculate(input)).isEqualTo(Integer.parseInt(answer));
    }
}
