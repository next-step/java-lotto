package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lotto.model.Reward.*;
import static lotto.model.Reward.FIFTH_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PrizesTest {

    @Test
    @DisplayName("상품 당첨 해쉬맵 테스트")
    void makePrizesTest() {
        List<Reward> rewards = new ArrayList<>();

        rewards.add(FIFTH_PRIZE);
        rewards.add(FOURTH_PRIZE);
        rewards.add(THIRD_PRIZE);
        rewards.add(FIFTH_PRIZE);

        Prizes prizes = new Prizes(rewards);

        assertAll(
                () -> assertThat(prizes.getPrizes().get(FIFTH_PRIZE)).isEqualTo(2),
                () -> assertThat(prizes.getPrizes().get(FOURTH_PRIZE)).isEqualTo(1),
                () -> assertThat(prizes.getPrizes().get(THIRD_PRIZE)).isEqualTo(1),
                () -> assertThat(prizes.getPrizes().get(FIRST_PRIZE)).isEqualTo(0)
        );
    }

    @Test
    void makeYieldTest() {
        List<Reward> rewards = new ArrayList<>();

        rewards.add(FIFTH_PRIZE);
        rewards.add(FOURTH_PRIZE);

        Prizes prizes = new Prizes(rewards);
        assertThat(prizes.makeYield(1000)).isEqualTo(BigDecimal.valueOf(55));
    }
}
