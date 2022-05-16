package lotto.domain.result;

import lotto.domain.LottoReward;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGameResultTest {
    LottoGameResult lottoGameResult;
    LottoMatchResults lottoMatchResults = new LottoMatchResults();

    @BeforeEach
    void setUp() {
        lottoMatchResults.addMatchNumber(LottoReward.MISS);
        lottoMatchResults.addMatchNumber(LottoReward.MISS);
        lottoMatchResults.addMatchNumber(LottoReward.FIFTH);
        lottoMatchResults.addMatchNumber(LottoReward.FOURTH);

        lottoGameResult = new LottoGameResult(lottoMatchResults, 4000);
    }

    @Test
    void 매치_개수_테스트() {
        LottoGameResult gameResult = new LottoGameResult(2000);
        gameResult.addMatchResult(LottoReward.FIFTH);
        gameResult.addMatchResult(LottoReward.FIFTH);

        LottoMatchResults matchResults = new LottoMatchResults();
        matchResults.addMatchNumber(LottoReward.FIFTH);
        matchResults.addMatchNumber(LottoReward.FIFTH);

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
