package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @Test
    public void matchAsThird() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6),44);
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,42));
        LottoMatch lottoMatch = new LottoMatch(winningLotto, userLotto);
        assertThat(lottoMatch.getProfit()).isEqualTo(LottoProfit.THIRD);
    }

    @Test
    public void matchAsSecond() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6),44);
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,7,44));
        LottoMatch lottoMatch = new LottoMatch(winningLotto, userLotto);
        assertThat(lottoMatch.getProfit()).isEqualTo(LottoProfit.SECOND);
    }
}
