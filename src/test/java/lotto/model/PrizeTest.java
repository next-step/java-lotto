package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizeTest {

    @Test
    void win() {
        assertThat(Prize.win(1)).isEqualTo(0);
        assertThat(Prize.win(2)).isEqualTo(0);
        assertThat(Prize.win(3)).isEqualTo(5000);
        assertThat(Prize.win(4)).isEqualTo(50000);
        assertThat(Prize.win(5)).isEqualTo(1500000);
        assertThat(Prize.win(6)).isEqualTo(2000000000);
    }
}
