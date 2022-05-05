package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGameResultTest {
    LottoGameResult lottoGameResult;
    LottoMatchResults lottoMatchResults = new LottoMatchResults();

    @BeforeEach
    void setUp() {
        lottoMatchResults.addMatchNumber(1);
        lottoMatchResults.addMatchNumber(1);
        lottoMatchResults.addMatchNumber(3);
        lottoMatchResults.addMatchNumber(4);

        lottoGameResult = new LottoGameResult(lottoMatchResults);
    }

    @Test
    void 매치_개수_테스트() {
        LottoGameResult gameResult = new LottoGameResult();
        gameResult.addMatchResult(3);
        gameResult.addMatchResult(3);

        LottoMatchResults matchResults = new LottoMatchResults();
        matchResults.addMatchNumber(3);
        matchResults.addMatchNumber(3);

        assertThat(gameResult).isEqualTo(new LottoGameResult(matchResults));
    }

    @Test
    void 상금_테스트() {
        assertThat(lottoGameResult.getTotalReward()).isEqualTo(5000 + 50000);
    }

    @Test
    void 수익률_테스트() {
        assertThat(lottoGameResult.getYield(4000)).isEqualTo((double) 55000/4000);
    }
}
