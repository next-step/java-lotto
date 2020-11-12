package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void dividedByTest() throws Exception {
        Money numerator = new Money(10000);
        Money denominator = new Money(1000);
        assertThat(numerator.dividedBy(denominator)).isEqualTo(10);
    }
}
