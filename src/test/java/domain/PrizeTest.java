package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("prize가 증가하면 PRIZE COUnt와 상금이 추가된다.")
    @Test
    void increase() {
        Prize prize = Prize.of();

        prize.increase(5000);

        assertThat(prize.getWinningCount()).isEqualTo(1);
        assertThat(prize.getWinningMoney()).isEqualTo(5000);
    }
}
