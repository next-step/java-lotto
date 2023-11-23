package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.Lotto;
import step2.lotto.domain.LottoPurchase;
import step2.lotto.domain.LottoRank;
import step2.lotto.domain.LottoScore;
import step2.lotto.domain.LottoWin;
import step2.lotto.domain.Lottos;

class LottoScoreTest {

    private Lottos lottos;
    private LottoWin lottoWin;
    private LottoScore lottoScore;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(Arrays.asList(
            Lotto.of(Set.of(1, 2, 3, 4, 5, 6)),
            Lotto.of(Set.of(10, 11, 12, 13, 14, 15))
        ));
        int bonusNumber = 7;
        lottoWin = new LottoWin(Set.of(1, 2, 3, 4, 5, 6), bonusNumber);
        lottoScore = LottoScore.create();
        lottoScore.recordMatchLotto(lottos, lottoWin);
    }


    @Test
    @DisplayName("우승 번호와 비교하여 맞은 LottoRank를 반환한다.")
    void finaMatchNumberCount() {
        assertThat(lottoScore.getLottoScore().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.LOSE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void calculateProfitRatioTest() {
        LottoPurchase purchaseInfo = new LottoPurchase(2000);
        System.out.println(lottoScore.calculateProfitRatio(purchaseInfo));

        assertThat(lottoScore.calculateProfitRatio(purchaseInfo)).isEqualTo(1000000.0);
    }

}