package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 로또_숫자_6자리_발급(){
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNums = lottoTicket.issueTicket();
        assertThat(lottoNums).hasSize(6);
    }

    @Test
    void 당첨번호_비교(){
        List<Integer> ticketNumbers = new ArrayList<>();
        ticketNumbers.add(1);
        ticketNumbers.add(2);
        ticketNumbers.add(3);
        ticketNumbers.add(4);
        ticketNumbers.add(5);
        ticketNumbers.add(6);
        LottoTicket lottoTicket = new LottoTicket(ticketNumbers);

        List<Integer> targetNumbers = new ArrayList<>();
        targetNumbers.add(1);
        targetNumbers.add(2);
        targetNumbers.add(3);
        targetNumbers.add(4);
        targetNumbers.add(5);
        targetNumbers.add(7);

        assertThat(lottoTicket.checkMatch(targetNumbers)).isEqualTo(5);
    }


}
