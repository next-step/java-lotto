package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNo bonus = LottoNoPool.getLottoNo(7);
        WinningCondition condition = new WinningCondition(winningLotto, bonus);

        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(2, 3, 4, 5, 6, 8)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)));
        result.increaseNumOfLotto(condition, new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
    }

    @Test
    @DisplayName("getNumOfLotto 확인")
    void getNumOfLotto() {
        Assertions.assertAll(
                () -> assertThat(result.getNumOfLotto(Rank.FIRST))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Rank.SECOND))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Rank.THIRD))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Rank.FOURTH))
                        .isEqualTo(2),
                () -> assertThat(result.getNumOfLotto(Rank.FIFTH))
                        .isEqualTo(3)
        );
    }

    @Test
    @DisplayName("profit 과 rateOfReturn 을 정상적으로 계산해야한다.")
    void getProfit() {
        int expectedProfit = 2031615000;
        double expectedRateOfReturn = 2846.2243255397575;
        Assertions.assertAll(
                () -> assertThat(result.getProfit())
                        .isEqualTo(new Money(expectedProfit)),
                () -> assertThat(result.getRateOfReturn(new Money(713793)))
                        .isEqualTo(expectedRateOfReturn)
        );
    }
}
