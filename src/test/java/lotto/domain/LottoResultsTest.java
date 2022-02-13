package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @Test
    void 결과를_업데이트_할_수_있다() {
        Map<Ranking, Integer> totalResult = new HashMap<>();
        LottoResults lottoResults = new LottoResults(totalResult);

        lottoResults.updateResults(Ranking.FIRST);
        lottoResults.updateResults(Ranking.SECOND);

        assertAll(
            () -> assertThat(lottoResults.getTotalResult().get(Ranking.FIRST)).isEqualTo(1),
            () -> assertThat(lottoResults.getTotalResult().get(Ranking.SECOND)).isEqualTo(1),
            () -> assertThat(lottoResults.getTotalResult().get(Ranking.THIRD)).isEqualTo(0),
            () -> assertThat(lottoResults.getTotalResult().get(Ranking.FOURTH)).isEqualTo(0),
            () -> assertThat(lottoResults.getTotalResult().get(Ranking.FIFTH)).isEqualTo(0)
        );
    }

    @Test
    void 수익률을_계산할_수_있다() {
        Map<Ranking, Integer> totalResult = new HashMap<>();
        LottoResults lottoResults = new LottoResults(totalResult);

        lottoResults.updateResults(Ranking.FIRST);
        lottoResults.updateResults(Ranking.SECOND);

        BigDecimal yield = lottoResults.calculateYield(new Money(10000));

        assertThat(yield).isEqualTo(BigDecimal.valueOf(20300000, 2));
    }
}
