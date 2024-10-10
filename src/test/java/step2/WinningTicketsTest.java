package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningTicketsTest {
    private WinningTickets winningTickets;

    @BeforeEach
    void before() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(10, 13, 39, 5, 23, 31));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        List<Integer> lottoNumbers3 = new ArrayList<>(Arrays.asList(39, 31, 40, 17, 5, 11));

        LottoTicket lottoTicket1 = new LottoTicket(lottoNumbers1);
        LottoTicket lottoTicket2 = new LottoTicket(lottoNumbers2);
        LottoTicket lottoTicket3 = new LottoTicket(lottoNumbers3);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(lottoTicket1);
        lottoTicketList.add(lottoTicket2);
        lottoTicketList.add(lottoTicket3);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        String[] winningNumbers = new String[]{"39", "5", "31", "1", "40", "11"};

        winningTickets = lottoTickets.findWinning(winningNumbers);
    }

    @Test
    @DisplayName("3개 번호 일치 티켓 수 2를 반환한다.")
    void 당첨_티켓_수_3개() {
        Assertions.assertThat(winningTickets.getThirdWinningCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("4개 번호 일치 티켓 수 0을 반환한다.")
    void 당첨_티켓_수_4개() {
        Assertions.assertThat(winningTickets.getFourthWinningCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("5개 번호 일치 티켓 수 1을 반환한다.")
    void 당첨_티켓_수_5개() {
        Assertions.assertThat(winningTickets.getFifthWinningCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("6개 번호 일치 티켓 수 0을 반환한다.")
    void 당첨_티켓_수_6개() {
        Assertions.assertThat(winningTickets.getSixthWinningCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("총 당첨된 금액을 반환한다.")
    void 총_당첨_금액() {
        Assertions.assertThat(winningTickets.getWinningPrice()).isEqualTo(1500000 + 5000 + 5000);
    }
}
