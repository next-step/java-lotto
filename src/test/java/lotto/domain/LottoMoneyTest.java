package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {

    @Test
    public void 한장_구매() {
        assertThat(new LottoMoney(1000).countOfLotto()).isEqualTo(1);
        assertThat(new LottoMoney(1999).countOfLotto()).isEqualTo(1);
    }

    @Test
    public void 두장_구매() {
        assertThat(new LottoMoney(2000).countOfLotto()).isEqualTo(2);
    }

    @Test(expected = RuntimeException.class)
    public void 천원_미만() {
        assertThat(new LottoMoney(999));
    }

    @Test
    public void 총수익률() {
        final long money = 4000;
        final LottoMoney lottoMoney = new LottoMoney(money);

        final Lotto anyLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto,
                new Lotto(Arrays.asList(
                        new LottoNumber(21), new LottoNumber(22), new LottoNumber(23),
                        new LottoNumber(24), new LottoNumber(25), new LottoNumber(26))),
                new Lotto(Arrays.asList(
                        new LottoNumber(31), new LottoNumber(32), new LottoNumber(33),
                        new LottoNumber(34), new LottoNumber(35), new LottoNumber(36))),
                new Lotto(Arrays.asList(
                        new LottoNumber(40), new LottoNumber(41), new LottoNumber(42),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        assertThat(lottoMoney.calculateEarningsRate(winningResults))
                .isEqualTo(Prize.FIRST.getMoney() / (double) money);
    }
}