package lotto.domain.dto;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.util.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketDtoTest {

    @DisplayName("LottoTickets 으로부터 List<LottoTicketDTO> 를 반환")
    @Test
    void from() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(Generator.lottoTicket(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        List<LottoTicketDto> ticketDTOS = LottoTicketDto.from(lottoTickets);

        assertThat(ticketDTOS.get(0).getNumbers()).isEqualTo(lottoNumbers);
    }
}
