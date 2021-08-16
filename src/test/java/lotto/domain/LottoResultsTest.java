package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    LottoResults lottoResults;

    @BeforeEach
    void setup() {
        List<LottoResult> results = new ArrayList<>();
        results.add(new LottoResult(0, Rank.FIRST));
        results.add(new LottoResult(2, Rank.FOURTH));
        lottoResults = new LottoResults(results);
    }

    @DisplayName("로또 수익률을 구한다.")
    @Test
    void calculateTotalRewardsRatio() {
        assertThat(lottoResults.calculateTotalRewardsRatio(3000))
                .isEqualTo(BigDecimal.valueOf(Rank.FOURTH.getRewards() * 2).divide(BigDecimal.valueOf(3000 * 100.), 2, RoundingMode.HALF_EVEN));
    }
}