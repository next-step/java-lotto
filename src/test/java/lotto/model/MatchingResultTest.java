package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.MatchingResult.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MatchingResultTest {
    @DisplayName("5등 로또의 갯수를 주면, 5등 상금  * 갯수를 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenFifth() {
        assertThat(FIFTH.calculatePrizeMoney(1))
                .isEqualTo(new Money(5000l));
    }

    @DisplayName("4등 로또의 갯수를 주면, 4등 상금 * 갯수를 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenFourth() {
        assertThat(FOURTH.calculatePrizeMoney(10))
                .isEqualTo(new Money(50_000l * 10));
    }

    @DisplayName("3등 로또의 갯수를 주면,  3등 상금 * 갯수를 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenThird() {
        assertThat(THIRD.calculatePrizeMoney(3))
                .isEqualTo(new Money(1_500_000l * 3));
    }

    @DisplayName("2등 로또의 갯수를 주면, 2등 상금 * 갯수 를 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenSecond() {
        assertThat(SECOND.calculatePrizeMoney(1))
                .isEqualTo(new Money(30_000_000l));
    }

    @DisplayName("1등 로또의 갯수를 주면, 1등 상금 * 갯수를 Money 객체로 반환한다.")
    @Test
    void calculatePrizeMoneyTestWhenFirst() {
        assertThat(FIRST.calculatePrizeMoney(5))
                .isEqualTo(new Money(2_000_000_000l * 5));
    }
}