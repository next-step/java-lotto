package lottoauto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lottoauto.LottoFixture;
import lottoauto.model.Lotto;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;
import lottoauto.model.WinningReward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또생성_및_리턴_테스트() {
        Integer integer = 3;
        Lotto lotto = LottoFixture.lottoFixture(integer);

        Assertions.assertThat(lotto.getNumbers().get(0)).isEqualTo(integer);
    }


    @Test
    void lottos_생성_및_출력테스트() {
        Integer integer = 3;
        Lotto lotto = LottoFixture.lottoFixture(integer);
        Lottos lottos = LottoFixture.lottosFixture(lotto);

        Assertions.assertThat(lottos.getLottos().get(0)).isEqualTo(lotto);
        Assertions.assertThat(lottos.getSize()).isEqualTo(1);
    }

    @Test
    void lottoResult_수익률_테스트() {
        int buyPrice = 10000;
        int matchCount = 3;
        List<Integer> result = LottoFixture.intListFixture(matchCount);

        int count = Collections.frequency(result, matchCount);
        double reward = WinningReward.findRewardByMatches(matchCount).getReward();
        LottoResult lottoResult = new LottoResult(result);

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(result.get(0));
        Assertions.assertThat(lottoResult.getRate(buyPrice)).isEqualTo(Math.round(count * reward / buyPrice));
    }
}
