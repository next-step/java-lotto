package calculator.domain;

import calculator.service.StringCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorServiceTest {
    @ParameterizedTest
    @ValueSource(strings = "2 + 3 * 4 / 2")
    @DisplayName("사칙연산을 순서대로 수행하는 테스트")
    void calculateTest(String input) {
        List<String> operations = StringCalculatorService.getOperations(input);

        assertThat(StringCalculatorService.calculate(operations)).isEqualTo(new CalcNumber(10));
    }
}
