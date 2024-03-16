package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("들어오는 숫자는 1~45의 숫자가 아닐경우 IllegalArgumentException을 던진다.")
    @Test
    public void throwIllegalArgumentExceptionWhenNumberIsNotBetweenOneToFortyFive() {
        //then
        assertThrows(IllegalArgumentException.class, () -> new Number(0));
        assertThrows(IllegalArgumentException.class, () -> new Number(47));

    }

    @DisplayName("들어오는 숫자는 1~45의 숫자일경우 예외를 던지지 않는다.")
    @Test
    public void notThrowAnyExceptionWhenNumberIsBetweenOneToFortyFive() {
        //then
        assertThat(new Number(4));
        assertThat(new Number(33));

    }
}