package calculator;

import calculator.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @DisplayName("마이너스 값을 가지고 있는 입력을 받을 시 RuntimeException")
    @MethodSource("provideMinusContainingStrings")
    void FailIfInputHasMinusValue(String input) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideMinusContainingStrings() {
        return Stream.of(
                Arguments.of("-23"),
                Arguments.of("//;\n1;-2;3"),
                Arguments.of("5:2,-3")
        );
    }

    @ParameterizedTest
    @DisplayName("Number의 덧셈 테스트")
    @MethodSource("provideNumbersForAdd")
    void add(Number left, Number right, Number expected) {
        Number actual = left.add(right);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNumbersForAdd() {
        return Stream.of(
                Arguments.of(new Number("5"), new Number("3"), new Number("8")),
                Arguments.of(new Number("23"), new Number("52"), new Number("75"))
        );
    }
}
