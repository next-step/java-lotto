package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<Lotto> lottos = Arrays.asList(Lotto.create(1,2,3,4,5,6), Lotto.create(1,2,3,4,5,7));
    private WinningLotto winningLotto = new WinningLotto(new Integer[]{1,2,3,4,5,6}, 7);
    private LottoResult lottoResult = new LottoResult(lottos, winningLotto);

    @Test
    public void 로또번호와_당첨번호를_통해_결과를_생성한다() {
        assertThat(lottoResult.count(Rank.First)).isEqualTo(1);
        assertThat(lottoResult.count(Rank.Second)).isEqualTo(1);
    }

    @Test
    public void 총_당첨금을_계산한다() {
        Long totalPrize = Rank.First.getPrizeMoney() + Rank.Second.getPrizeMoney();

        Long prizeMoney = lottoResult.calculatePrizeMoney();
        assertThat(prizeMoney).isEqualTo(totalPrize);
    }
}
