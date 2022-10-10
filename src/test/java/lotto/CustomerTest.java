package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @ParameterizedTest
    @CsvSource(value={"500:0", "1000:1", "14000:14", "14500:14"}, delimiter = ':')
    void buy(int cashAmount, int purchasedLottoCount) {
        Customer customer = new Customer();
        customer.buy(cashAmount);

        assertThat(customer.getLottoWallet().getLottos()).hasSize(purchasedLottoCount);
    }

}
