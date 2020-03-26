package stringaccumulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAccumulatorTest {

    @DisplayName("표현식을 입력 받아 새로운 StringAccumulator 를 생성할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"", "1,2", "1,2,3", "1,2:3"})
    public void newStringAccumInstanceTest(String expression) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        String takeNewOne = stringAccumulator.getExpression();

        assertThat(takeNewOne).isEqualTo(expression);
    }

    @DisplayName("같은 값으로 생성한 StringAccumulator 인스턴스는 같다")
    @Test
    public void sameCreatedSameExpressionTest() {
        String expression = "1,2";

        assertThat(new StringAccumulator(expression))
                .isEqualTo(new StringAccumulator(expression));
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @EmptySource
    public void nullStringReturnsZero(String expression) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        List<String> separateExpression = stringAccumulator.getSeparateExpression();
        int sum = stringAccumulator.sum(separateExpression);

        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullSource
    public void nullReturnsZero(String expression) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        List<String> separateExpression = stringAccumulator.getSeparateExpression();
        int sum = stringAccumulator.sum(separateExpression);

        assertThat(expression).isNull();
        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void returnsItSelfOnNumberSizeOne(String expression) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        List<String> separateExpression = stringAccumulator.getSeparateExpression();

        int sum = stringAccumulator.sum(separateExpression);
        int expected = Integer.parseInt(expression);

        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2 : 3", "2,3 : 5"}, delimiter = ':')
    public void returnsSumOfTwoNumbersWithComma(String expression, int expectedSum) {
        StringAccumulator stringAccumulator = new StringAccumulator(expression);

        List<String> separateExpression = stringAccumulator.getSeparateExpression();
        int sum = stringAccumulator.sum(separateExpression);

        assertThat(sum).isEqualTo(expectedSum);
    }
}
