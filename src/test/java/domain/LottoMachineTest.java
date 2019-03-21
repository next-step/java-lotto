package domain;

import org.junit.Test;

import java.util.ArrayList;
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
    public void init_winning_numbers() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(1,2,3,4,5,6);
        lottoMachine.initBonusNumber(7);

        assertThat(lottoMachine.getWinningNumbers()).isNotNull();
        assertThat(lottoMachine.getWinningNumbers().matchCount(new Lotto(1,2,3,4,5,6))).isEqualTo(6);

        assertThat(lottoMachine.getBonusNumber()).isNotNull();
        assertThat(lottoMachine.getBonusNumber()).isEqualTo(LottoNumber.getInstance(7));
    }

    @Test(expected = IllegalStateException.class)
    public void get_rank_didnt_set_winning_numbers_yet() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(1,2,3,4,5,6);

        lottoMachine.calculateRank(new Lotto(1,2,3,4,5,6));
    }

    @Test
    public void get_rank_from_lotto() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(4,5,6,7,8,9);
        lottoMachine.initBonusNumber(10);

        Rank rank1 = lottoMachine.calculateRank(new Lotto(1,2,3,4,5,6));
        assertThat(rank1).isEqualTo(Rank.Fifth);

        Rank rank2 = lottoMachine.calculateRank(new Lotto(4,5,6,7,8,10));
        assertThat(rank2).isEqualTo(Rank.Second);
    }

    @Test
    public void get_ranks_from_lottos() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(4,5,6,7,8,9);
        lottoMachine.initBonusNumber(10);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(1,2,3,4,5,6));
        lottos.add(new Lotto(1,2,3,4,5,6));

        List<Rank> ranks = lottoMachine.calculateRanks(lottos);

        assertThat(ranks).hasSize(2);
        assertThat(ranks).allMatch(r -> r == Rank.Fifth);
    }
}
