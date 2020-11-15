package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private Lotto winningLotto;
    private Result result;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        result = new Result(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)),
                new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9))
        ), winningLotto);
    }

    @Test
    @DisplayName("winningLotto 의 번호와 얼마나 일치하는지 결과를 보여줘야 한다.")
    void getNumOfLotto() {
        Assertions.assertAll(
                () -> assertThat(result.getNumOfLotto(Jackpot.THREE))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Jackpot.FOUR))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Jackpot.FIVE))
                        .isEqualTo(2),
                () -> assertThat(result.getNumOfLotto(Jackpot.SIX))
                        .isEqualTo(1)
        );
    }

    @Test
    @DisplayName("profit 과 rateOfReturn 을 정상적으로 계산해야한다.")
    void getProfit() {
        int expectedProfit = 2003055000;
        double expectedRateOfReturn = 2806.0;
        Assertions.assertAll(
                () -> assertThat(result.getProfit())
                        .isEqualTo(new Money(expectedProfit)),
                () -> assertThat(result.getRateOfReturn(new Money(713793)))
                        .isEqualTo(expectedRateOfReturn)
        );
    }
}
