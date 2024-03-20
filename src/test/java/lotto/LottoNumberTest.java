package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @DisplayName("들어오는 숫자는 1~45의 숫자가 아닐경우 IllegalArgumentException을 던진다.")
    @Test
    public void throwIllegalArgumentExceptionWhenNumberIsNotBetweenOneToFortyFive() {
        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(47));

    }

    @DisplayName("들어오는 숫자는 1~45의 숫자일경우 예외를 던지지 않는다.")
    @Test
    public void notThrowAnyExceptionWhenNumberIsBetweenOneToFortyFive() {
        //then
        assertThat(new LottoNumber(4));
        assertThat(new LottoNumber(33));

    }
}