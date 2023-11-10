package me.namuhuchutong.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorsTest {

    @DisplayName("주어진 식에서 사칙 연산자를 찾을 수 없다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "assaf 123ds sdfa23",
            "#$&3563asdfa sdf3sd fad",
            "@#$$%^& (33) #534#%$#%$#",
            "dsafasdfadsfsdfawerz",
            "1 @ 3 $ 5 & 9 23 ^ 23"
    })
    void throw_exception_when_no_operators(String given) {
        //given
        String input = StringTrimmer.trimmedInput(given);

        //when, then
        assertThatThrownBy(() -> Operators.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 계산식은 우선순위 없이 입력 순서대로 계산된다.")
    @ParameterizedTest
    @MethodSource("givenInputAndExpected")
    void calculate_without_priority(String given, int expected) {
        //given
        String input = StringTrimmer.trimmedInput(given);
        Operators operators = Operators.from(input);
        Operands operands = Operands.from(input);

        //when
        int result = operators.calculate(operands);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> givenInputAndExpected() {
        return Stream.of(
                Arguments.arguments("1 / 3 + 2 * 4 - 2", 6),
                Arguments.arguments("1 + 2 * 4 / 2 - 1", 5),
                Arguments.arguments("2 + 3 * 4 / 2", 10)
        );
    }

}
