package Lotto.Ticket;

import Lotto.Number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("로또 티켓 리스트는 n장의 로또 티켓으로 초기화 된다. ")
    @ParameterizedTest(name = "티켓 {0}장")
    @ValueSource(ints = {1, 2, 3})
    void createLottoTickets(int totalTicketNum) {
        LottoTickets lottoTickets = new LottoTickets(getMockLottoTickets(totalTicketNum));
        assertThat(lottoTickets.getValue().size()).isEqualTo(totalTicketNum);
    }

    private List<LottoTicket> getMockLottoTickets(int totalTicketNumber) {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());

        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < totalTicketNumber; i++) {
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }

        return lottoTickets;
    }
}
