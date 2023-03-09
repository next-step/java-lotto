package pluscalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusCalculatorTest {
    static class PlusCalculator {
        public static Numbers extractNumbers(final String plusExpression) {
            String[] splitNumbers = plusExpression.split(",");
            return new Numbers(Arrays.stream(splitNumbers).map(Integer::parseInt).collect(Collectors.toList()));
        }
    }

    static class Numbers {
        private final List<Integer> numbers;

        public Numbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public int plusAll() {
            return numbers.stream().reduce(0, Integer::sum);
        }
    }

    @ParameterizedTest
    @CsvSource({"'11,55,44', 110",
            "'1,2,3', 6"})
    @DisplayName("쉼표를 포함한 문자열을 분리해서 계산한다.")
    void commaSplit(String plusExpression, int expectValue) {

        Numbers numbers = PlusCalculator.extractNumbers(plusExpression);
        int sum = numbers.plusAll();

        Assertions.assertThat(sum).isEqualTo(expectValue);
    }
}
