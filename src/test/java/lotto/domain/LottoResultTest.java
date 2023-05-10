package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private static final List<Rank> ranks = Arrays.asList(Rank.SECOND_PLACE, Rank.SECOND_PLACE, Rank.THIRD_PLACE, Rank.FOURTH_PLACE, Rank.LOST);
    private static final LottoResult lottoResult = new LottoResult(ranks);

    @Test
    @DisplayName("[요구사항 1] 주어진 복권 결과들 중 2등은 2개이다.")
    void 요구사항_1() {
        // given
        int secondPlaceCount = 2;
        Rank rank = Rank.SECOND_PLACE;

        // then
        assertThat(lottoResult.findWinningCount(rank)).isEqualTo(secondPlaceCount);
    }

    @Test
    @DisplayName("[요구사항 2] 주어진 복권의 수익률은 611.0이다.")
    void 요구사항_2() {
        // given
        double expectedRateOfReturn = 611.0;

        // then
        assertThat(lottoResult.findRateOfReturn()).isEqualTo(expectedRateOfReturn);
    }
}
