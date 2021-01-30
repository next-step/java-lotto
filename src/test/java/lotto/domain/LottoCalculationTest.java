package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCalculationTest {
    static LottoCalculation lottoCalculation;

    @BeforeAll
    static void initAll() {
        lottoCalculation = new LottoCalculation();
    }

    @Test
    void isWinningBallTest() {
        List<Integer> winningBalls = Arrays.asList(1, 2, 3, 4);
        Assertions.assertThat(lottoCalculation.isWinningBall(1, winningBalls)).isTrue();
        Assertions.assertThat(lottoCalculation.isWinningBall(10, winningBalls)).isFalse();
    }

}
