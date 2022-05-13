package lotto.domain.result;

import lotto.domain.LOTTO_REWARD;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LottoMatchResultsTest {
    @Test
    void 상금_테스트() {
        LottoMatchResults lottoMatchResults = new LottoMatchResults();
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.MISS);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.MISS);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.FIFTH);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.FOURTH);

        assertThat(lottoMatchResults.getLottoReward()).isEqualTo(5000 + 50000);
    }

    @Test
    void 당첨_증가_테스트() {
        LottoMatchResults lottoMatchResults = new LottoMatchResults();
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.FIRST);

        assertThat(lottoMatchResults.getLottoReward()).isEqualTo(2_000_000_000);
    }
}
