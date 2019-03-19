package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void buy_lotto_using_money_until_you_can() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(14000);
        assertThat(lottos).hasSize(14);
    }

    @Test
    public void lotto_hit_count() {
        LottoMachine lottoMachine = new LottoMachine();

        Lotto lotto = new Lotto(1,2,3,4,5,6);

        lottoMachine.setWinningNumbers(new WinningNumbers(4,5,6,7,8,9));
        int matchCount = lottoMachine.calculateMatchCount(lotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    public void get_rank_from_lotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.setWinningNumbers(new WinningNumbers(4,5,6,7,8,9));
        Rank rank = lottoMachine.calculateRank(new Lotto(1,2,3,4,5,6));

        assertThat(rank).isEqualTo(Rank.Fourth);
    }
}
