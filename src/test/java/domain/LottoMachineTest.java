package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    public void 가능한_개수만큼_로또를_구매한다() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchase(14000);
        assertThat(lottos).hasSize(14);
    }

    @Test
    public void 당첨번호를_설정한다() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(1,2,3,4,5,6);
        lottoMachine.initBonusNumber(7);

        assertThat(lottoMachine.getWinningNumbers()).isNotNull();
        assertThat(lottoMachine.getWinningNumbers().matchCount(new Lotto(1,2,3,4,5,6))).isEqualTo(6);

        assertThat(lottoMachine.getBonusNumber()).isNotNull();
        assertThat(lottoMachine.getBonusNumber()).isEqualTo(LottoNumber.getInstance(7));
    }

    @Test
    public void 로또의_순위를_얻어온다() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(4,5,6,7,8,9);
        lottoMachine.initBonusNumber(10);

        Rank rank1 = lottoMachine.calculateRank(new Lotto(1,2,3,4,5,6));
        assertThat(rank1).isEqualTo(Rank.Fifth);

        Rank rank2 = lottoMachine.calculateRank(new Lotto(4,5,6,7,8,10));
        assertThat(rank2).isEqualTo(Rank.Second);
    }

    @Test(expected = IllegalStateException.class)
    public void 당첨번호가_설정되지_않았는데_순위를_얻어오면_예외가_발생한다() {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.initWinningNumbers(1,2,3,4,5,6);

        lottoMachine.calculateRank(new Lotto(1,2,3,4,5,6));
    }

    @Test
    public void 로또들의_순위들을_얻어온다() {
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
