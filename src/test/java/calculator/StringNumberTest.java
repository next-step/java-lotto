package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumberTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator(generateCalculateStrategys());
    }

    private List<CalculateStrategy> generateCalculateStrategys() {
        return Arrays.asList(new PlusCalculate(), new MinusCalculate(), new MultiplicationCalculate(), new DivisionCalculate());
    }

    @ParameterizedTest(name = "계산기 결과확인.")
    @CsvSource(value = {"2 + 3 * 4 / 2|10", "2 + 3 * 4 / 2 + 2|12", "2 + 3 * 4 + 2|22"}, delimiter = '|')
    void 계산기(String input, int result) {
        assertThat(stringCalculator.calculation(input)).isEqualTo(result);
    }


}
