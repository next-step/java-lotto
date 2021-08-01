package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    private LottoTicket winningTicket;
    private LottoTicket firstPrizeTicket;
    private LottoTicket thirdPrizeTicket;
    private LottoTicket fourthPrizeTicket;
    private LottoTicket fifthPrizeTicket;
    private LottoTicket noPrizeTicket;

    @BeforeEach
    void setUp() {
        winningTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 3, 4, 5, 6));
        firstPrizeTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 3, 4, 5, 6));
        thirdPrizeTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 3, 4, 5, 7));
        fourthPrizeTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 3, 4, 7, 8));
        fifthPrizeTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 3, 7, 8, 9));
        noPrizeTicket = LottoTicket.createFromList(Arrays.asList(1, 2, 9, 10, 11, 12));
    }

    @Test
    void match() {
        List<LottoTicket> ticketList = Arrays.asList(firstPrizeTicket, thirdPrizeTicket);
        LottoTickets lottoTickets = LottoTickets.createFromTicketList(ticketList);

        LottoResult expectedResults = LottoResult.createEmpty();
        expectedResults.update(LottoRank.FIRST, 1);
        expectedResults.update(LottoRank.THIRD, 1);

        LottoResult actualResults = lottoTickets.match(winningTicket);
        assertThat(actualResults).isEqualTo(expectedResults);
    }
}
