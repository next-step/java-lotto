package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 당첨금합계() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9))));
        Lottos lottos = new Lottos(lottoList);
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lottos.totalPrize(winningLotto);
        assertThat(result).isEqualTo(1550000);
    }

    @Test
    public void 등수별_당첨자수() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7))));
        lottoList.add(new Lotto(new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 10))));
        Lottos lottos = new Lottos(lottoList);
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int result = lottos.rankCount(winningLotto, Winning.FOURTH.getRank());
        assertThat(result).isEqualTo(1);
    }
}