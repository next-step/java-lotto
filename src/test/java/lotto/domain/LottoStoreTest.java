package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoStoreTest {
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
            final LottoStore lottoStore = new LottoStore();
            final int paymentLessThanPrice = 500;

            lottoStore.lottoTickets(paymentLessThanPrice);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"9800:9:true", "14000:14:true", "5000:7:false"}, delimiter = ':')
    public void purchasable(String paymentValue, String countValue, String expectedValue) {
        final int payment = Integer.parseInt(paymentValue);
        final int count = Integer.parseInt(countValue);
        final boolean expected = Boolean.parseBoolean(expectedValue);


        final boolean result = new LottoStore().purchasable(payment, count);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 10})
    public void allLottoTickets(int manualLottoTicketsCount) {
        final int payment = 10000;
        final LottoTickets manualLottoTickets = new LottoTickets(
                Stream.generate(LottoTicketFactory::createAutoLottoTicket)
                        .limit(manualLottoTicketsCount)
                        .collect(Collectors.toList())
        );
        final LottoStore lottoStore = new LottoStore();

        final AllLottoTickets allLottoTickets = lottoStore.allLottoTickets(payment, manualLottoTickets);

        assertThat(allLottoTickets.manualLottoTicketsCount()).isEqualTo(manualLottoTickets.count());
    }
}
