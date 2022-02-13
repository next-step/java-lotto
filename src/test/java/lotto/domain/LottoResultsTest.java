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
        final Map<Ranking, Integer> totalResult = new HashMap<>();
        final LottoResults lottoResults = new LottoResults(totalResult);

        lottoResults.updateResults(Ranking.FIRST);
        lottoResults.updateResults(Ranking.SECOND);

        assertAll(
            () -> assertThat(lottoResults.getTotalResult()).containsEntry(Ranking.FIRST, 1),
            () -> assertThat(lottoResults.getTotalResult()).containsEntry(Ranking.SECOND, 1),
            () -> assertThat(lottoResults.getTotalResult()).containsEntry(Ranking.THIRD, 0),
            () -> assertThat(lottoResults.getTotalResult()).containsEntry(Ranking.FOURTH, 0),
            () -> assertThat(lottoResults.getTotalResult()).containsEntry(Ranking.FIFTH, 0)
        );
    }

    @Test
    void 수익률을_계산할_수_있다() {
        final Map<Ranking, Integer> totalResult = new HashMap<>();
        final LottoResults lottoResults = new LottoResults(totalResult);

        lottoResults.updateResults(Ranking.FIRST);
        lottoResults.updateResults(Ranking.SECOND);

        final BigDecimal yield = lottoResults.calculateYield(new Money(10000));

        assertThat(yield).isEqualTo(BigDecimal.valueOf(20300000, 2));
    }
}
