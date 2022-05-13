package lotto.domain.result;

import lotto.domain.LOTTO_REWARD;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGameResultTest {
    LottoGameResult lottoGameResult;
    LottoMatchResults lottoMatchResults = new LottoMatchResults();

    @BeforeEach
    void setUp() {
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.MISS);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.MISS);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.FIFTH);
        lottoMatchResults.addMatchNumber(LOTTO_REWARD.FOURTH);

        lottoGameResult = new LottoGameResult(lottoMatchResults, 4000);
    }

    @Test
    void 매치_개수_테스트() {
        LottoGameResult gameResult = new LottoGameResult(2000);
        gameResult.addMatchResult(LOTTO_REWARD.FIFTH);
        gameResult.addMatchResult(LOTTO_REWARD.FIFTH);

        LottoMatchResults matchResults = new LottoMatchResults();
        matchResults.addMatchNumber(LOTTO_REWARD.FIFTH);
        matchResults.addMatchNumber(LOTTO_REWARD.FIFTH);

        assertThat(gameResult).isEqualTo(new LottoGameResult(matchResults, 2000));
    }

    @Test
    void 상금_테스트() {
        assertThat(lottoGameResult.getTotalReward()).isEqualTo(5000 + 50000);
    }

    @Test
    void 수익률_테스트() {
        assertThat(lottoGameResult.getYield()).isEqualTo((double) 55000/4000);
    }
}
