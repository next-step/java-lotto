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
                LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto,
                new Lotto(Arrays.asList(
                        LottoNumber.from(21), LottoNumber.from(22), LottoNumber.from(23),
                        LottoNumber.from(24), LottoNumber.from(25), LottoNumber.from(26))),
                new Lotto(Arrays.asList(
                        LottoNumber.from(31), LottoNumber.from(32), LottoNumber.from(33),
                        LottoNumber.from(34), LottoNumber.from(35), LottoNumber.from(36))),
                new Lotto(Arrays.asList(
                        LottoNumber.from(40), LottoNumber.from(41), LottoNumber.from(42),
                        LottoNumber.from(43), LottoNumber.from(44), LottoNumber.from(45)))));

        WinningResults winningResults = LottoMatcher.calculateWinningResults(lottos, winningLotto);

        assertThat(lottoMoney.calculateEarningsRate(winningResults))
                .isEqualTo(Rank.FIRST.getMoney() / (double) money);
    }
}