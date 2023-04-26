package study.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static study.lotto.domain.LottoScoreType.*;

class LottoScoreTest {

    @Test
    void 로또결과_숫자_한개_맞음() {
        LottoScore lottoScoreSet = LottoScore.generate();
        assertThat(lottoScoreSet.getScoreMap().get(ONE)).isEqualTo(0);

        // 하나 맞았음
        lottoScoreSet.addScore(ONE);
        assertThat(lottoScoreSet.getScoreMap().get(ONE)).isEqualTo(1);
    }

    @Test
    void 로또결과_숫자_다맞음() {
        LottoScore lottoScoreSet = LottoScore.generate();
        assertThat(lottoScoreSet.getScoreMap().get(SIX)).isEqualTo(0);

        lottoScoreSet.addScore(SIX);
        assertThat(lottoScoreSet.getScoreMap().get(SIX)).isEqualTo(1);
    }

    @Test
    void 총_상금_계산() {
        LottoScore lottoScore = LottoScore.generate();
        lottoScore.addScore(SIX);
        assertThat(lottoScore.getTotalReward()).isEqualTo(SIX.getReward());
        lottoScore.addScore(FIVE);
        assertThat(lottoScore.getTotalReward()).isEqualTo(SIX.getReward() + FIVE.getReward());
    }
}