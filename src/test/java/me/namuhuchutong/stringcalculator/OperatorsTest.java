package me.namuhuchutong.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
        String input = trimmedInput(given);

        //when, then
        assertThatThrownBy(() -> Operators.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private String trimmedInput(String input) {
        return input.replaceAll(" ", "");
    }
}
