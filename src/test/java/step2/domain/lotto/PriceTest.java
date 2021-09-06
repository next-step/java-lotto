package step2.domain.lotto;

import org.junit.jupiter.api.Test;
import step2.domain.statistics.Amount;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {
    @Test
    void purchaseAmountTest() {
        final int inputPrice = 14000;
        final Price price = new Price(inputPrice);
        final Amount actual = price.amount();
        final Amount expected = new Amount(14);
        assertThat(actual).isEqualTo(expected);
    }
}
