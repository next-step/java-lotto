package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWallet;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoWalletTest {
    private List<Integer> INPUT_LOTTO_NUMBER_SAMPLE = Arrays.asList(1, 2, 3, 4, 5, 6);
    private LottoTicket sampleTicket = LottoTicket.of(INPUT_LOTTO_NUMBER_SAMPLE);

    @Test
    void create() {
        List<LottoTicket> ticketList = Arrays.asList(sampleTicket, sampleTicket);
        LottoTickets tickets = new LottoTickets(ticketList);

        new LottoWallet(tickets, tickets);
    }
}
