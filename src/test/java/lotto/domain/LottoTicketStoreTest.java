package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketStoreTest {

    private LottoTicketStore store;

    @BeforeEach
    void setUp() {
        store = new LottoTicketStore(new RandomNumbersGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 900})
    @DisplayName("1000원 이하 입력 시 예외가 발생한다")
    void ticketPriceExceptionTest(int price) {
        assertThatThrownBy(() -> store.buy(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 2200})
    @DisplayName("구입 금액 입력 시 금액만큼 로또 티켓을 발급한다")
    void ticketBuyTest(int price) {
        LottoTickets lottoTickets = store.buy(price);
        assertThat(lottoTickets.size()).isEqualTo(price / 1000);
    }
}
