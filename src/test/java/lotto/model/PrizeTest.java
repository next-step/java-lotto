package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrizeTest {

    @Test
    void test_valueOf() {
        assertThat(Prize.valueOf(0)).isEqualTo(Prize.LOSE);
        assertThat(Prize.valueOf(3)).isEqualTo(Prize.FOURTH);
    }
}
