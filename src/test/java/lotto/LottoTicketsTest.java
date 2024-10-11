package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 티켓들 중 3개~6개의 번호가 일치하는 티켓의 수를 반환한다.")
    void 당첨_티켓_수() {
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

        WinningTickets winningTickets = lottoTickets.findWinning(winningNumbers);

        Assertions.assertThat(winningTickets.getThirdWinningCount()).isEqualTo(2);
        Assertions.assertThat(winningTickets.getFourthWinningCount()).isEqualTo(0);
        Assertions.assertThat(winningTickets.getFifthWinningCount()).isEqualTo(1);
        Assertions.assertThat(winningTickets.getSixthWinningCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("발행된 로또 티켓의 수를 반환한다.")
    void 티켓_수() {
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

        Assertions.assertThat(lottoTickets.getLottoTicketsSize()).isEqualTo(3);
    }
}
