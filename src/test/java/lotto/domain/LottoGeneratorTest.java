package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("자동 티켓 생성 테스트")
    public void generateAutoTicketTest() throws TicketNumberOutOfBoundException {
        assertThat(LottoGenerator.generateAutoTickets(14).numberOfTickets()).isEqualTo(14);
    }

    @Test
    @DisplayName("수동 티켓 생성 테스트")
    public void generateManualTicketTest() throws TicketNumberOutOfBoundException {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(Ticket.from(List.of(1, 2, 3, 4, 5, 45)));
        ticketList.add(Ticket.from(List.of(2, 33, 23, 31, 32, 8)));
        assertThat(LottoGenerator.generateManualTickets(ticketList).numberOfTickets()).isEqualTo(2);
    }
}
