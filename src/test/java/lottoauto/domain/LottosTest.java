package lottoauto.domain;

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
        WinningReward winningReward = WinningReward.MATCH_3;
        List<WinningReward> result = List.of(winningReward);

        int count = Collections.frequency(result, winningReward);
        LottoResult lottoResult = new LottoResult(result, buyPrice);

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(result.get(0));
        Assertions.assertThat(lottoResult.calculateRate()).isEqualTo(Math.round(count * (double) winningReward.getReward() / buyPrice));
    }
}
