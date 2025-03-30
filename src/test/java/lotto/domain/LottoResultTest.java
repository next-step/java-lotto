package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("당첨 결과를 추가하면 해당 결과의 개수가 증가한다.")
    @Test
    void add() {
        // given
        List<LottoResult.Rank> ranks = Arrays.asList(LottoResult.Rank.FOURTH,
                LottoResult.Rank.FOURTH, LottoResult.Rank.THIRD);
        LottoResult lottoResult = new LottoResult(ranks);

        // when
        Map<LottoResult.Rank, Long> statistics = lottoResult.getStatistics();

        // then
        assertThat(statistics.get(LottoResult.Rank.FOURTH)).isEqualTo(2);
        assertThat(statistics.get(LottoResult.Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 MISS 등수로 처리된다.")
    @Test
    void addLessThanThree() {
        // given
        List<LottoResult.Rank> ranks = Arrays.asList(LottoResult.Rank.MISS, LottoResult.Rank.MISS);
        LottoResult lottoResult = new LottoResult(ranks);

        // when
        Map<LottoResult.Rank, Long> statistics = lottoResult.getStatistics();

        // then
        assertThat(statistics.get(LottoResult.Rank.MISS)).isEqualTo(2);
    }

    @DisplayName("당첨금을 계산한다.")
    @Test
    void calculateTotalPrize() {
        // given
        List<LottoResult.Rank> ranks = Arrays.asList(LottoResult.Rank.FOURTH,
                LottoResult.Rank.THIRD, LottoResult.Rank.SECOND, LottoResult.Rank.FIRST);
        LottoResult lottoResult = new LottoResult(ranks);

        // when
        long totalPrize = lottoResult.calculateTotalPrize();

        // then
        long expected = 5_000 + 50_000 + 1_500_000 + 2_000_000_000;
        assertThat(totalPrize).isEqualTo(expected);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<LottoResult.Rank> ranks = Arrays.asList(LottoResult.Rank.FOURTH); // 5,000원
        LottoResult lottoResult = new LottoResult(ranks);

        // when
        double profitRate = lottoResult.calculateProfitRate(1000);

        // then
        assertThat(profitRate).isEqualTo(5.0);
    }
}
