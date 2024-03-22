package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    @Test
    void generateRandomNumbers() {
        assertThat(Rule.generateRandomNumbers().size()).isEqualTo(6);
        Rule.generateRandomNumbers().forEach(number -> assertThat(number).isBetween(1, 45));
    }

    @Test
    void is_payment_sufficient() {
        assertThat(Rule.isNotPaymentSufficientForLotto(0)).isTrue();
    }

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
