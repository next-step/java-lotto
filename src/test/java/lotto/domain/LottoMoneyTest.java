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
                LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto,
                new Lotto(Arrays.asList(
                        LottoNumber.of(21), LottoNumber.of(22), LottoNumber.of(23),
                        LottoNumber.of(24), LottoNumber.of(25), LottoNumber.of(26))),
                new Lotto(Arrays.asList(
                        LottoNumber.of(31), LottoNumber.of(32), LottoNumber.of(33),
                        LottoNumber.of(34), LottoNumber.of(35), LottoNumber.of(36))),
                new Lotto(Arrays.asList(
                        LottoNumber.of(40), LottoNumber.of(41), LottoNumber.of(42),
                        LottoNumber.of(43), LottoNumber.of(44), LottoNumber.of(45)))));

        WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        assertThat(lottoMoney.calculateEarningsRate(winningResults))
                .isEqualTo(Rank.FIRST.getMoney() / (double) money);
    }
}