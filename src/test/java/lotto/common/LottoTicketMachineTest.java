package lotto.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketMachineTest {

    @DisplayName("입력한 숫자만큼 로또 티켓 자동 발행")
    @Test
    void issueTickets() {
        int ticketCount = 3;
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();

        //when
        List<LottoTicket> lottoTickets = lottoTicketMachine.issueTickets(ticketCount);

        //then
        assertEquals(ticketCount, lottoTickets.size());
    }

    @DisplayName("입력받은 문자열로 LottoTicket 생성")
    @Test
    void issueTicket() {
        //given
        String numberValues = "1, 2, 3, 4, 5, 6";

        //when
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        LottoTicket actual = lottoTicketMachine.issueTicket(numberValues);

        //then
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());
        LottoTicket expected = new LottoTicket(lottoNumbers);
        assertEquals(expected, actual);
    }
}