package LottoTests;

import lotto.model.LottoPurchaseTickets;
import lotto.model.LottoStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoStore 테스트")
public class LottoStoreTests {

    @DisplayName("로또 판매 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10000,10", "54321,5", "912,0", "0,0"})
    public void sellTest(Integer payment, Integer expectedLottoTicketsSize) {
        LottoPurchaseTickets lottoPurchaseTickets = LottoStore.sell(payment);
        assertThat(lottoPurchaseTickets.size()).isEqualTo(expectedLottoTicketsSize);
    }
}
