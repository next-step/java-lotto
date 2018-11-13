package game.lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberPoolTest {

    @Test
    public void 로또번호_가져오기() {
        final int number = 3;

        LottoNumber number1 = LottoNumberPool.getLottoNumber(number);
        LottoNumber number2 = LottoNumberPool.getLottoNumber(number);

        assertThat(number1).isSameAs(number2);
        assertThat(number1.getValue()).isEqualTo(number);
        assertThat(number2.getValue()).isEqualTo(number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_가져오기_범위보다_작은수() {
        final int number = LottoNumber.MIN - 1;

        LottoNumberPool.getLottoNumber(number);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_가져오기_범위보다_큰수() {
        final int number = LottoNumber.MAX + 1;

        LottoNumberPool.getLottoNumber(number);
    }

}