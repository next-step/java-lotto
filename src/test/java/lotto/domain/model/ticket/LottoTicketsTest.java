package lotto.domain.model.ticket;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.model.result.LottoRank;
import lotto.dto.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    private WinningTicket winningTicket;
    private List<LottoTicket> ticketList;
    private LottoResult expected;

    @BeforeEach
    void setUp() {
        LottoTicket lottoTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = LottoNumber.of(7);
        winningTicket = WinningTicket.of(lottoTicket, bonusNumber);

        ticketList = new ArrayList<>(Arrays.asList(
                LottoTicket.of("1, 2, 3, 4, 5, 7"),
                LottoTicket.of("1, 2, 3, 4, 5, 6")
        ));

        expected = LottoResult.empty();
        expected.add(LottoRank.FIRST);
        expected.add(LottoRank.SECOND);
    }

    @Test
    void match_SingleCount() {
        LottoTickets lottoTickets = LottoTickets.of(ticketList);
        LottoResult lottoResult = lottoTickets.match(winningTicket);
        assertThat(lottoResult).isEqualTo(expected);
    }

    @Test
    void match_MultipleCounts() {
        ticketList.add(LottoTicket.of("1, 2, 3, 4, 5, 7"));
        expected.add(LottoRank.SECOND);
        LottoTickets lottoTickets = LottoTickets.of(ticketList);
        LottoResult lottoResult = lottoTickets.match(winningTicket);
        assertThat(lottoResult).isEqualTo(expected);
    }
}
