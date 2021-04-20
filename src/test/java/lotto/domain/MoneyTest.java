package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    public void 로또_구매_갯수() {
        assertThat(new Money().buyCount(4_000)).isEqualTo(4);
    }

}