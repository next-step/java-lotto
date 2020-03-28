package lotto;

import lotto.model.MatchingResult;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingResultTest {
    @DisplayName("당첨번호와 3개가 같은 로또 갯수를 주면, 받을 수 있는 상금을 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenThreeMatching() {
        assertThat(MatchingResult.THREE.calculatePrizeMoney(1))
                .isEqualTo(new Money(5000l));
    }

    @DisplayName("당첨번호와 4개가 같은 로또 갯수를 주면, 받을 수 있는 상금을 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenFourMatching() {
        assertThat(MatchingResult.FOUR.calculatePrizeMoney(2))
                .isEqualTo(new Money(100000l));
    }

    @DisplayName("당첨번호와 5개가 같은 로또 갯수를 주면, 받을 수 있는 상금을 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenFiveMatching() {
        assertThat(MatchingResult.FIVE.calculatePrizeMoney(3))
                .isEqualTo(new Money(4500000l));
    }

    @DisplayName("당첨번호와 6개가 같은 로또 갯수를 주면, 받을 수 있는 상금을 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenSixMatching() {
        assertThat(MatchingResult.SIX.calculatePrizeMoney(5))
                .isEqualTo(new Money(10000000000l));
    }
}