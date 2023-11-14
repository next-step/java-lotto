package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasicOperatorTest {
    @ParameterizedTest
    @DisplayName("사칙연산 확인")
    @CsvSource(value = {"2 + 3 * 4 / 2"})
    void calculator_확인(String a) {
        List<String> input = Arrays.asList(a.split(" "));
        int result = Integer.parseInt(input.get(0));
        for (int i = 1; i < input.size() - 1; i += 2) {
            BasicOperator basicOperator = BasicOperator.mapping(String.valueOf(input.get(i)));
            result = basicOperator.apply(result, Integer.parseInt(input.get(i + 1)));
        }
        assertThat(result).isEqualTo(10);
    }
}