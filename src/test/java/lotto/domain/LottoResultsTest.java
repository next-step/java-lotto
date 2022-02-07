package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.factory.WinningBallFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private List<UserLotto> lottos;
    private List<WinningBall> winningBalls;
    private Map<UserLotto, WinningInfo> winningInfoOfLotto;
    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottos = new ArrayList<>();
        lottos.add(new UserLotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 당첨_심사_테스트_일반당첨() {
        String[] numbers = {"1", "2", "3", "4", "40", "41"};
        winningBalls = WinningBallFactory.of(numbers, "45");

        LottoResults lottoResults = new LottoResults(lottos, winningBalls);
        assertThat(lottoResults.getResults().get(0)).isEqualTo(LottoResult.FOUR_MATCHING);
    }
}
