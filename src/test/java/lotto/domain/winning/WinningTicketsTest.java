package lotto.domain.winning;

import lotto.domain.LottoRank;
import lotto.domain.ticket.LottoNumber;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTicketsTest {
    private WinningTickets winningTickets;

    @BeforeEach
    void before() {
        winningTickets = getWinningTickets();
    }

    @Test
    @DisplayName("당첨된 티켓 수를 반환하며, 5등 1개, 3등 1개, 2등 1개를 반환해야 한다.")
    void 당첨_티켓_수() {
        assertThat(winningTickets.getWinningTicketCount(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(winningTickets.getWinningTicketCount(LottoRank.THIRD)).isEqualTo(1);
        assertThat(winningTickets.getWinningTicketCount(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 당첨된 금액을 반환한다.")
    void 총_당첨_금액() {
        assertThat(winningTickets.getWinningPrice()).isEqualTo(5_000 + 1_500_000 + 30_000_000);
    }

    private WinningTickets getWinningTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(Stream.of(10, 13, 39, 5, 23, 31)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));
        LottoTicket lottoTicket2 = new LottoTicket(Stream.of(5, 39, 1, 7, 31, 11)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));

        LottoTicket lottoTicket3 = new LottoTicket(Stream.of(39, 31, 40, 17, 5, 11)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));

        List<LottoTicket> lottoTicketList = List.of(lottoTicket1, lottoTicket2, lottoTicket3);
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        return lottoTickets.findWinning(getWinningNumbers());
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(List.of(39, 5, 31, 1, 40, 11),
                                  new LottoNumber(17));
    }

}
