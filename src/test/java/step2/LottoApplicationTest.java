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

    @Test
    void issueLottos() {
        final int numberOfPurchases = 14;
        final Lottos lottos = LottoApplication.issueLottos(numberOfPurchases);
        final int actual = lottos.count();
        final int expected = numberOfPurchases;
        assertThat(actual).isEqualTo(expected);
    }
}
