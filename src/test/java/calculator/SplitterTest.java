package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitterTest {

    private final Splitter splitter = new Splitter();

    private final Operand one = new Operand("1");
    private final Operand two = new Operand("2");
    private final Operand three = new Operand("3");
    private final Operand four = new Operand("4");

    private final Operands oneTwoThree = new Operands(Arrays.asList(one, two, three));
    private final Operands oneTwoThreeFour = new Operands(Arrays.asList(one, two, three, four));

    @Test
    void split() {
        assertThat(splitter.split("1,2:3")).isEqualTo(oneTwoThree);
        assertThat(splitter.split("1,2:3;4", ",|:|;")).isEqualTo(oneTwoThreeFour);
    }

    @Test
    void splitFail_delimiter() {
        assertThatThrownBy(() -> {
            splitter.split("1,2,3", null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("delimiter는 null일 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource(value = "provideTextAndErrorMessage")
    void splitFail(String text, String message) {
        assertThatThrownBy(() -> {
            splitter.split(text);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    private static Stream<Arguments> provideTextAndErrorMessage() {
        return Stream.of(
                Arguments.of("", "피연산자는 0 이상의 양수여야합니다."),
                Arguments.of(null, "text는 null일 수 없습니다.")
        );
    }

}
