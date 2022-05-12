package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LottoMatchResultsTest {
    @Test
    void 상금_테스트() {
        LottoMatchResults lottoMatchResults = new LottoMatchResults();
        lottoMatchResults.addMatchNumber(1);
        lottoMatchResults.addMatchNumber(1);
        lottoMatchResults.addMatchNumber(3);
        lottoMatchResults.addMatchNumber(4);

        assertThat(lottoMatchResults.getLottoReward()).isEqualTo(5000 + 50000);
    }
}
