package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }


    @DisplayName("null 값이나 빈 값은 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void addTest(String input) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }


    @DisplayName("구분자 ':' 더하기 코드는 성공한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2|3", "1:2:3|6"}, delimiter = '|')
    void addByColonTest(String input, int expect) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("구분자 ',' 더하기 코드는 성공한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2,3|6"}, delimiter = '|')
    void addByCommaTest(String input, int expect) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("구분자 ',' or ':' 더하기 코드는 성공한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,2:3|6", "1:2,4,5:6|18"}, delimiter = '|')
    void addByCommaOrColonTest(String input, int expect) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("숫자 하나만 있을 경우 그 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1|1", "1|1"}, delimiter = '|')
    void oneNumberTest(String input, int expect) {
        int result = stringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }
}
