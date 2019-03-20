package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrizeTest {

    @Test
    public void valueOf() {
        assertThat(Prize.valueOf(3).getMoney()).isEqualTo(Prize.FOURTH.getMoney());
        assertThat(Prize.valueOf(3).getMoney()).isNotEqualTo(Prize.THIRD.getMoney());
        assertThat(Prize.valueOf(3).getMoney()).isNotEqualTo(Prize.SECOND.getMoney());
        assertThat(Prize.valueOf(3).getMoney()).isNotEqualTo(Prize.FIRST.getMoney());
    }
}