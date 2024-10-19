package lotto.domain.ticket;

import lotto.domain.LottoRank;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void before() {
        lottoTickets = getLottoTickets();
        winningNumbers = getWinningNumbers();
    }

    @Test
    @DisplayName("로또 티켓들 중 3개~6개의 번호가 일치하는 티켓의 수를 반환하며, 5등 2개, 3등 1개를 반환해야 한다.")
    void 당첨_티켓_수() {
        WinningTickets winningTickets = lottoTickets.findWinning(winningNumbers);

        int fifthWinningCount = winningTickets.getWinningTicketCount(LottoRank.FIFTH);
        int fourthWinningCount = winningTickets.getWinningTicketCount(LottoRank.FOURTH);
        int thirdWinningCount = winningTickets.getWinningTicketCount(LottoRank.THIRD);

        assertThat(fifthWinningCount).isEqualTo(2);
        assertThat(fourthWinningCount).isEqualTo(0);
        assertThat(thirdWinningCount).isEqualTo(1);
    }

    @Test
    @DisplayName("발행된 로또 티켓의 수를 반환한다.")
    void 로또_티켓_수() {
        assertThat(lottoTickets.getLottoTicketsSize()).isEqualTo(3);
    }

    private LottoTickets getLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(Stream.of(10, 13, 39, 5, 23, 31)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));
        LottoTicket lottoTicket2 = new LottoTicket(Stream.of(1, 3, 5, 7, 9, 11)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));

        LottoTicket lottoTicket3 = new LottoTicket(Stream.of(39, 31, 40, 17, 5, 11)
                                                         .map(LottoNumber::new)
                                                         .collect(Collectors.toList()));

        List<LottoTicket> lottoTicketList = List.of(lottoTicket1, lottoTicket2, lottoTicket3);

        return new LottoTickets(lottoTicketList);
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(List.of(39, 5, 31, 1, 40, 11),
                                  new LottoNumber(16));
    }
}
