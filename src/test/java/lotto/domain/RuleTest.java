package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    @Test
    void is_not_range() {
        assertThat(Rule.isNotInRange(0)).isTrue();
    }

    @Test
    void rule() {
        assertThat(Rule.MIN_NUMBER == Rule.MIN_NUMBER).isTrue();
        assertThat(Rule.MAX_NUMBER == Rule.MAX_NUMBER).isTrue();
        assertThat(Rule.LOTTO_PRICE == Rule.LOTTO_PRICE).isTrue();
        assertThat(Rule.NUMBERS_OF_BALLS == Rule.NUMBERS_OF_BALLS).isTrue();
    }
}
