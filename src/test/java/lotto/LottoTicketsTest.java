package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {

    @DisplayName(value = "구매한 만큼 티켓이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void 여러장의_티켓_구매(int purchaseCount) {
        // given
        List<LottoTicket> manualLottoTicketList = new ArrayList<>();
        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseCount, manualLottoTicketList);

        // then
        assertThat(lottoTickets.size()).isEqualTo(purchaseCount);
    }

    @DisplayName(value = "수동구매와 자동구매를 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 10})
    void 수동구매와_자동구(int purchaseCount) {
        // given
        List<LottoTicket> manualLottoTicketList = new ArrayList<>();

        List<Number> numbers = new ArrayList<>();
        numbers.add(Number.newNumber(1));
        numbers.add(Number.newNumber(2));
        numbers.add(Number.newNumber(3));
        numbers.add(Number.newNumber(4));
        numbers.add(Number.newNumber(5));
        numbers.add(Number.newNumber(6));

        LottoTicket lottoTicket = LottoTicket.newTicket(numbers);
        manualLottoTicketList.add(lottoTicket);

        LottoTickets lottoTickets = LottoTickets.newTickets(purchaseCount, manualLottoTicketList);

        // then
        assertThat(lottoTickets.size()).isEqualTo(purchaseCount);
    }
}