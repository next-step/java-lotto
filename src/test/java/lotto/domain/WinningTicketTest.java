package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTicketTest {

    @Test
    void constructor() throws Exception {
        //given

        //when

        //then
        assertDoesNotThrow(() -> {
            new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        });
    }
    
    @Test
    void countMatching() throws Exception {
        //given
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList, new RandomNumberCreation());
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        //when
        Map<LottoRank, Integer> result = winningTicket.countMatching(lottoTickets);

        //then
        assertThat(result).containsKeys(LottoRank.FIFTH, LottoRank.FIRST).containsValues(1, 2);
    }
}
