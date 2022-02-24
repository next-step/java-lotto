package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoFixtures;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Test;

class LottoJudgementTest {

    @Test
    void 입력된_로또_수와_결과_수가_동일해야_한다() {
        //TODO: 원인 파악
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_FOUR_MATCHING);

        assertThat(lottoJudgement.getLottoResults()).hasSize(lottos.size());
    }

    @Test
    void 당첨개수_3_미만이면_당첨에_실패한다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_TWO_REWARD);

        assertThat(lottoJudgement.getLottoResults().get(0)).isEqualTo(LottoResult.NO_REWARD);
    }

    @Test
    void 당첨개수_3개면_상금이_5_000원이다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_THREE_MATCHING);

        assertThat(lottoJudgement.getLottoResults().get(0).getReward()).isEqualTo(5000);
    }

    @Test
    void 당첨개수_4개면_상금이_50_000원이다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_FOUR_MATCHING);

        assertThat(lottoJudgement.getLottoResults().get(0).getReward()).isEqualTo(50_000);
    }

    @Test
    void 당첨개수_5개면_상금이_1_500_000원이다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_FIVE_MATCHING);

        assertThat(lottoJudgement.getLottoResults().get(0).getReward()).isEqualTo(1_500_000);
    }

    @Test
    void 당첨개수_5개와_보너스볼이_일치하면_상금이_30_000_000원이다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_FIVE_MATCHING_BONUS);

        assertThat(lottoJudgement.getLottoResults().get(0).getReward()).isEqualTo(30_000_000);
    }

    @Test
    void 당첨개수_6개면_상금이_2_000_000_000원이다() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(LottoFixtures.NORMAL_LOTTO_NUMBER));
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_SIX_MATCHING);

        assertThat(lottoJudgement.getLottoResults().get(0).getReward()).isEqualTo(2_000_000_000);
    }
}
