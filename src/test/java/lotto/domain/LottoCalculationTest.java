package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculationTest {
    static LottoCalculation lottoCalculation;

    @BeforeAll
    static void initAll() {
        lottoCalculation = new LottoCalculation();
    }

    @Test
    void calculateResultTest() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 11, 12));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);

        Map<WinningType, Integer> matchResult = new HashMap<>();
        matchResult.put(WinningType.SIX, 1);
        matchResult.put(WinningType.FIVE, 1);
        matchResult.put(WinningType.FIVE_BONUS, 0);
        matchResult.put(WinningType.FOUR, 1);
        matchResult.put(WinningType.THREE, 0);
        WinningLotto winningLotto = WinningLotto.generate(winningNumbers, 7);
        Assertions.assertThat(LottoCalculation.calculateResult(winningLotto, lottos)).isEqualTo(matchResult);
    }


    @Test
    void winningBallMatchNumberTest() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.generate(winningNumbers, 7);
        Assertions.assertThat(LottoCalculation.winningBallMatchNumber(winningLotto, lotto)).isEqualTo(6);
    }

    @Test
    void getProfitRateTest() {
        Map<WinningType, Integer> matchResult = new HashMap<>();
        matchResult.put(WinningType.SIX, 1);
        matchResult.put(WinningType.FIVE, 1);
        matchResult.put(WinningType.FIVE_BONUS, 0);
        matchResult.put(WinningType.FOUR, 0);
        matchResult.put(WinningType.THREE, 0);
        Assertions.assertThat(LottoCalculation.getProfitRate(matchResult, 10000)).isEqualTo(200150.0f);
    }

    @Test
    void isWinningBallTest() {
        List<Integer> winningBalls = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoCalculation.isWinningBall(1, winningBalls)).isTrue();
        Assertions.assertThat(lottoCalculation.isWinningBall(10, winningBalls)).isFalse();
    }

    @Test
    void hasBonusBallTest() {
        List<Integer> winningBalls = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusBall = 6;
        Assertions.assertThat(lottoCalculation.hasBonusBall(winningBalls, bonusBall)).isTrue();
    }

}
