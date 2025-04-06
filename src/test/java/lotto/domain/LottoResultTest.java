package lotto.domain;

import lotto.support.LottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private final Lotto winning = LottoFixture.of(1, 2, 3, 4, 5, 6);

    @DisplayName("일치 개수에 따라 Rank를 반환한다.")
    @ParameterizedTest(name = "{1} 일치 시 {0} 등수로 카운트 된다")
    @CsvSource({
            "THREE, 1,2,3,10,11,12",
            "FOUR, 1,2,3,4,11,12",
            "FIVE, 1,2,3,4,5,10",
            "SIX, 1,2,3,4,5,6"
    })
    void countByRank(Rank expectedRank, int n1, int n2, int n3, int n4, int n5, int n6) {
        Lotto ticket = LottoFixture.of(n1, n2, n3, n4, n5, n6);
        Lottos lottos = new Lottos(List.of(ticket));
        LottoResult result = new LottoResult(lottos, winning);
        Map<Rank, Integer> stats = result.getResults();

        assertThat(stats.get(expectedRank)).isEqualTo(1);
    }

    @DisplayName("총 수익률을 계산한다")
    @Test
    void calculatesCorrectProfitRate() {
        Lottos lottos = new Lottos(List.of(
                LottoFixture.of(1, 2, 3, 10, 11, 12),
                LottoFixture.of(1, 2, 3, 4, 11, 12)
        ));
        LottoResult result = new LottoResult(lottos, winning);
        double profitRate = result.calculateProfitRate(2_000);

        assertThat(profitRate).isEqualTo((5_000 + 50_000) / 2000.0);
    }
}
