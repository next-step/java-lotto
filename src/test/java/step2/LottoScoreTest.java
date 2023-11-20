package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchaseInfo;
import step2.lotto.domain.LottoRank;
import step2.lotto.domain.LottoScore;
import step2.lotto.domain.LottoWinNumberInfo;
import step2.lotto.domain.Lottos;

class LottoScoreTest {

    @Test
    @DisplayName("우승 번호와 비교하여 맞은 LottoRank를 반환한다.")
    void finaMatchNumberCount() {
        Lottos lottos = new Lottos(Arrays.asList(
            new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
            new Lotto(Set.of(10, 11, 12, 13, 14, 15))
        ));
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(Set.of(1, 2, 3, 4, 5, 6));

        LottoScore lottoScore = new LottoScore();
        lottoScore.recordMatchLotto(lottos, lottoWinNumberInfo);

        assertThat(lottoScore.getLottoScore().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.LOSE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void calculateProfitRatioTest() {
        Lottos lottos = new Lottos(Arrays.asList(
            new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
            new Lotto(Set.of(10, 11, 12, 13, 14, 15)),
            new Lotto(Set.of(10, 11, 12, 13, 14, 15))
        ));
        LottoWinNumberInfo lottoWinNumberInfo = new LottoWinNumberInfo(Set.of(1, 2, 3, 4, 5, 6));
        LottoScore lottoScore = new LottoScore();
        lottoScore.recordMatchLotto(lottos, lottoWinNumberInfo);
        LottoPurchaseInfo purchaseInfo = new LottoPurchaseInfo(2000);
        System.out.println(lottoScore.calculateProfitRatio(purchaseInfo));

        assertThat(lottoScore.calculateProfitRatio(purchaseInfo)).isEqualTo(1000000.0);
    }

}