package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또생성() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    public void 당첨결과_일치하는숫자갯수() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lotto.matchCount(winningLotto);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void n장의_당첨결과_일치하는숫자갯수() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)));
        Lotto lotto3 = new Lotto(new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8)));
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lotto.matchCount(winningLotto);
        assertThat(result).isEqualTo(5);
        result = lotto2.matchCount(winningLotto);
        assertThat(result).isEqualTo(4);
        result = lotto3.matchCount(winningLotto);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void lotto의_당첨금() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lotto.prize(winningLotto).getPrize();
        assertThat(result).isEqualTo(1500000);
    }

    @Test
    public void lotto의_등수() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lotto.rank(winningLotto).getRank();
        assertThat(result).isEqualTo(2);
    }

}