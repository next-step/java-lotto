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
    void test_get_count_of_matching_numbers() {
        assertThat(Prize.FIRST.getCountOfMatchingNumbers()).isEqualTo(6);
    }

    @Test
    void test_get_prize_money() {
        assertThat(Prize.SECOND.getPrizeMoney()).isEqualTo(1_500_000);
    }
}
