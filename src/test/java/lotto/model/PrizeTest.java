package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizeTest {

    @Test
    void test_valueOf() {
        assertThat(Prize.valueOf(0)).isEqualTo(Prize.LOSE);
        assertThat(Prize.valueOf(3)).isEqualTo(Prize.FOURTH);
    }

    @Test
    void test_getters() {
        assertThat(Prize.valueOf(0).getCountOfWinningNumbers()).isEqualTo(0);
        assertThat(Prize.valueOf(0).getPrizeMoney()).isEqualTo(0);

        assertThat(Prize.valueOf(3).getCountOfWinningNumbers()).isEqualTo(3);
        assertThat(Prize.valueOf(3).getPrizeMoney()).isEqualTo(5000);
    }
}
