package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
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
    private LottoPurchase lottoPurchase;

    @BeforeEach
    void setUp() {
        lottoPurchase = new LottoPurchase(6000,
            List.of("1, 2, 3, 4, 5, 6",
                "10, 11, 12, 13, 14, 15",
                "1, 2, 3, 9, 10, 11",
                "1, 2, 3, 4, 8, 9",
                "1, 2, 3, 4, 5, 8",
                "1, 2, 3, 4, 5, 7"
            )
        );
        lottos = Lottos.purchaseLottos(lottoPurchase);
        int bonusNumber = 7;
        lottoWin = new LottoWin(Set.of(1, 2, 3, 4, 5, 6), bonusNumber);
        lottoScore = LottoScore.create();
        lottoScore.recordMatchLotto(lottos, lottoWin);
    }


    @Test
    @DisplayName("우승 번호와 비교하여 맞은 LottoRank를 반환한다.")
    void finaMatchNumberCount() {
        assertThat(lottoScore.getLottoScore().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.FORTH)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoScore.getLottoScore().get(LottoRank.LOSE)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void calculateProfitRatioTest() {
        assertThat(lottoScore.calculateProfitRatio(lottoPurchase)).isEqualTo(338592.0);
    }

}