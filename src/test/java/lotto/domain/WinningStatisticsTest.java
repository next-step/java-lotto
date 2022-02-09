package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    List<LottoResult> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        results.add(LottoResult.SIX_MATCHING);
        results.add(LottoResult.FIVE_MATCHING_BONUS);
    }

    @Test
    void 총_결과를_반환할_수_있다() {
        HashMap<LottoResult, Integer> result = WinningStatistics.getResult(results);

        assertThat(result.get(LottoResult.SIX_MATCHING)).isEqualTo(1);
        assertThat(result.get(LottoResult.FIVE_MATCHING_BONUS)).isEqualTo(1);
    }

    @Test
    void 총_수익률을_반환할_수_있다() {
        HashMap<LottoResult, Integer> result = WinningStatistics.getResult(results);

        assertThat(WinningStatistics.getProfitRate(result, 1000)).isEqualTo("2030000.00");
    }

}