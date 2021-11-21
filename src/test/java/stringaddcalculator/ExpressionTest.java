package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ExpressionTest {

    @DisplayName("expression에 null 또는 빈 문자열이 주어졌을 때 null or empty 여부를 반환하는지 검증")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        Expression expression = new Expression(input);
        assertThat(expression.isNullOrEmpty()).isTrue();
    }

    @DisplayName("expression가 주어졌을 때 정수 list만 뽑아내는 지 검증")
    @ParameterizedTest
    @MethodSource("numbersParameter")
    void numbersTest(String input, Numbers numbers) {
        Expression expression = new Expression(input);
        assertThat(expression.numbers()).isEqualTo(numbers);
    }

    private static Stream<Arguments> numbersParameter() {
        Numbers numbers = new Numbers(Arrays.asList(new Number(1), new Number(2), new Number(3)));
        return Stream.of(Arguments.of("//'\n1'2'3", numbers),
                         Arguments.of("//;\n1;2;3", numbers),
                         Arguments.of("1:2:3", numbers),
                         Arguments.of("1,2:3", numbers));
    }
}
