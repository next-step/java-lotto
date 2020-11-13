package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("increaseNumOfLotto 를 하면 numOfLotto 값이 증가해야한다.")
    void increaseNumOfLotto() {
        Result result = new Result();
        result.increaseNumOfLotto(Jackpot.FOUR);
        result.increaseNumOfLotto(Jackpot.FIVE);
        result.increaseNumOfLotto(Jackpot.FIVE);
        result.increaseNumOfLotto(Jackpot.SIX);
        result.increaseNumOfLotto(Jackpot.SIX);
        result.increaseNumOfLotto(Jackpot.SIX);
        Assertions.assertAll(
                () -> assertThat(result.getNumOfLotto(Jackpot.THREE))
                        .isEqualTo(0),
                () -> assertThat(result.getNumOfLotto(Jackpot.FOUR))
                        .isEqualTo(1),
                () -> assertThat(result.getNumOfLotto(Jackpot.FIVE))
                        .isEqualTo(2),
                () -> assertThat(result.getNumOfLotto(Jackpot.SIX))
                        .isEqualTo(3)
        );
    }

    @Test
    @DisplayName("profit 과 rateOfReturn 을 정상적으로 계산해야한다.")
    void getRateOfReturn() {
        Result result = new Result();
        result.increaseNumOfLotto(Jackpot.THREE);
        result.increaseNumOfLotto(Jackpot.THREE);
        result.increaseNumOfLotto(Jackpot.THREE);
        result.increaseNumOfLotto(Jackpot.FOUR);
        result.increaseNumOfLotto(Jackpot.FOUR);
        result.increaseNumOfLotto(Jackpot.FIVE);

        int expectedProfit = 1615000;
        int purchase = 161500;
        int expectedRateOfReturn = 10;
        Money purchaseMoney = new Money(purchase);
        Assertions.assertAll(
                () -> assertThat(result.getProfit())
                        .isEqualTo(new Money(expectedProfit)),
                () -> assertThat(result.getRateOfReturn(purchaseMoney))
                        .isEqualTo(expectedRateOfReturn)
        );
    }
}
