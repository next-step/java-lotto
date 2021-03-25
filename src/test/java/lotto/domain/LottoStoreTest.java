package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {
    @Test
    public void create() {
        assertThat(new LottoStore()).isEqualTo(new LottoStore());
    }

    @ParameterizedTest
    @CsvSource(value = {"9800:9", "14000:14"}, delimiter = ':')
    public void lottoTickets(String price, String expected) {
        final int priceValue = Integer.parseInt(price);
        final int expectedValue = Integer.parseInt(expected);

        final int resultValue = new LottoStore().lottoTickets(priceValue).size();

        assertThat(resultValue).isEqualTo(expectedValue);
    }

    @Test
    public void lottoTicketsLessThanPrice() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final int price = 1000;
            final LottoStore lottoStore = new LottoStore(price);
            final int paymentLessThanPrice = 500;

            lottoStore.lottoTickets(paymentLessThanPrice);
        });
    }
}
