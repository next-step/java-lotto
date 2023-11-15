package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class LottoResultTest {

    @Test
    @DisplayName("로또 결과를 기준으로 당첨 통계를 구한다.")
    void success_generate_lotto_statistics() {
        Map<LottoRank, Long> lottoResults = Map.ofEntries(
                entry(LottoRank.FIFTH, 1L),
                entry(LottoRank.FOURTH, 1L),
                entry(LottoRank.THIRD, 1L),
                entry(LottoRank.SECOND, 0L),
                entry(LottoRank.FIRST, 1L)
        );

        LottoResult lottoResult = new LottoResult(lottoResults);
        List<LottoWinResult> lottoWinResults = lottoResult.lottoStatistics();

        assertThat(lottoWinResults).hasSize(5)
                .extracting("machCount", "prizeAmount", "winCount", "isBonus")
                .containsExactlyInAnyOrder(
                        tuple(3L, 5_000L, 1L, false),
                        tuple(4L, 50_000L, 1L, false),
                        tuple(5L, 1_500_000L, 1L, false),
                        tuple(5L, 30_000_000L, 0L, true),
                        tuple(6L, 2_000_000_000L, 1L, false)
                );
    }

}
