package me.namuhuchutong.stringcalculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperandsTest {

    @DisplayName("주어진 식에 숫자가 없을 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a * b / c + d - e",
            "# * ! / c + ) - (",
            "abc * dabcd - scc",
    })
    void throw_exception_when_no_operands(String given) {
        ///given
        String input = StringTrimmer.trimmedInput(given);

        //when, then
        assertThatThrownBy(() -> Operands.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
