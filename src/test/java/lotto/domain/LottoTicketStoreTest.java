package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketStoreTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 2200})
    @DisplayName("구입 금액 입력 시 금액만큼 로또 티켓을 발급한다")
    void test(int price) {
        LottoTicketStore store = new LottoTicketStore(new RandomNumbersGenerator());
        LottoTickets lottoTickets = store.buy(price);
        assertThat(lottoTickets.size()).isEqualTo(price / 1000);
    }
}
