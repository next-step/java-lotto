package calculator;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    private static Stream<Arguments> provideStringsForAddNumbers() {
        return Stream.of(
                Arguments.of(Arrays.array("1", "2", "3"), 6),
                Arguments.of(Arrays.array("10", "20"), 30),
                Arguments.of(Arrays.array("100", "120", "50", "1"), 271)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForAddNumbers")
    @DisplayName("분리된 숫자들 더하기")
    void addNumbers(String[] input, int expected) {
        // given
        Expression expression = new Expression(input);

        // when
        int result = expression.addNumbers();

        // then
        assertThat(result).isEqualTo(expected);
    }

}
