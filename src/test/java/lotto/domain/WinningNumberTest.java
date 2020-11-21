package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("당첨번호에 1~45 에 포함되지 않는 값을 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,50", "1,2,3,4,5,-1"})
    void invalidNumber(String expression){
        assertThatThrownBy(() -> new WinningNumber(expression))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨번호에 null 이나 빈값을 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidNumber2(String expression){
        assertThatThrownBy(() -> new WinningNumber(expression))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨번호에 숫자아 아닌 문자를 넣으면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,a,4,5,6", "@,3,4,5,2,6"})
    void invalidNumber3(String expression){
        assertThatThrownBy(() -> new WinningNumber(expression))
                .isInstanceOf(InvalidWinningNumberException.class);
    }
}