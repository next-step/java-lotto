package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizeTest {

    @Test
    void win() {
        Prize.win(3);
        Prize.win(3);
        Prize.win(4);

        assertThat(Prize.PRIZE.get(3).get(1)).isEqualTo(2);
        assertThat(Prize.PRIZE.get(4).get(1)).isEqualTo(1);
    }
}
