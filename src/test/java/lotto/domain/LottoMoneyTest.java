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
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto,
                new Lotto(Arrays.asList(
                        LottoNumber.valueOf(21), LottoNumber.valueOf(22), LottoNumber.valueOf(23),
                        LottoNumber.valueOf(24), LottoNumber.valueOf(25), LottoNumber.valueOf(26))),
                new Lotto(Arrays.asList(
                        LottoNumber.valueOf(31), LottoNumber.valueOf(32), LottoNumber.valueOf(33),
                        LottoNumber.valueOf(34), LottoNumber.valueOf(35), LottoNumber.valueOf(36))),
                new Lotto(Arrays.asList(
                        LottoNumber.valueOf(40), LottoNumber.valueOf(41), LottoNumber.valueOf(42),
                        LottoNumber.valueOf(43), LottoNumber.valueOf(44), LottoNumber.valueOf(45)))));

        MatchResults matchResults = LottoMatcher.calculateMatchResults(lottos, winningLotto);

        assertThat(lottoMoney.calculateEarningsRate(matchResults))
                .isEqualTo(Rank.FIRST.getMoney() / (double) money);
    }
}