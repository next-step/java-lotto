package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultsTest {
    @Test
    @DisplayName("5등을 두번 추가하면 5등 결과는 2개이다")
    void name() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.add(Rank.FIFTH);
        lottoResults.add(Rank.FIFTH);
        assertThat(lottoResults.getWinningCount(Rank.FIFTH)).isEqualTo(2);
    }
}
