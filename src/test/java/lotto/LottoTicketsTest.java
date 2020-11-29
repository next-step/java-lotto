package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {

    @DisplayName(value = "구매한 만큼 티켓이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void 여러장의_티켓_구매(int purchaseNumber) {
        // given
        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseNumber);

        // then
        assertThat(lottoTickets.size()).isEqualTo(purchaseNumber);
    }
}