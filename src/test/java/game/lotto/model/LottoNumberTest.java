package game.lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void 로또번호만들기() {
        final int inputNumber = 2;
        LottoNumber lottoNumber = new LottoNumber(inputNumber);

        assertThat(lottoNumber.getValue()).isEqualTo(inputNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호만들기_범위보다_작은값() {
        final int lowerNumber = 0;

        new LottoNumber(lowerNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호만들기_범위보다_큰값() {
        final int graterNumber = 46;

        new LottoNumber(graterNumber);
    }
}