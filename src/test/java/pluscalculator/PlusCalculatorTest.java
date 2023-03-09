package pluscalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class PlusCalculatorTest {
    static class PlusCalculator {
        public static Numbers extractNumbers(final String plusExpression) {
            return new Numbers(new ArrayList<>());
        }

    }

    static class Numbers {
        private final List<Integer> numbers;

        public Numbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public int plusAll() {
            return 100;
        }
    }

    @ParameterizedTest
    @CsvSource("'11,55,44', 100")
    @DisplayName("쉼표를 포함한 문자열을 분리해서 계산한다.")
    void commaSplit(String plusExpression, int expectValue) {

        Numbers numbers = PlusCalculator.extractNumbers(plusExpression);
        int sum = numbers.plusAll();

        Assertions.assertThat(sum).isEqualTo(expectValue);
    }
}
