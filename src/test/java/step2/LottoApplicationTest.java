package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoApplicationTest {
    @Test
    void purchaseAmountTest() {
        final int inputValue = 14000;
        final int count = LottoApplication.getNumberOfPurchases(inputValue);
        final int expected = 14;
        assertThat(count).isEqualTo(expected);
    }
}
