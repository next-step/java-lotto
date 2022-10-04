package stringCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringCalculator.service.CalculateService;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateServiceImplTest {

    private static CalculateService calculateService = new CalculateService();

    @ParameterizedTest
    @CsvSource(value = {"1 + 1=2", "1 + 4 - 3=2", "1 - 1 + 5 * 10=50", "1 + 2 * 3 - 3 / 2=3", "1 * 2 + 8 / 5=2"}, delimiter = '=')
    void 문자열을_입력_시_사칙연산_수행_후_결과값_응답(String input, int answer) {
        assertThat(calculateService.calculate(input)).isEqualTo(answer);
    }
}
