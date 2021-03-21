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
    @CsvSource(value = {"0:0", "9800:9", "14000:14"}, delimiter = ':')
    public void lottoTickets(String price, String expected) {
        final int priceValue = Integer.parseInt(price);
        final int expectedValue = Integer.parseInt(expected);

        final int resultValue = new LottoStore().lottoTickets(priceValue).size();

        assertThat(resultValue).isEqualTo(expectedValue);
    }

    @Test
    public void lottoTicketsNegativePrice() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoStore().lottoTickets(-1000));
    }
}
