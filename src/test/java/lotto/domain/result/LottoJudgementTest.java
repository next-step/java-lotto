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
        LottoJudgement lottoJudgement = new LottoJudgement(lottos, LottoFixtures.WINNING_NUMBERS_FIVE_MATCHING);

        assertThat(lottoJudgement.getLottoResults()).hasSize(lottos.size());
    }
}
