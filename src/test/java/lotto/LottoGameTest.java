package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameTest {

    @Test
    void 로또_결과를_확인() {
        // given
        List<Integer> testTicket = Arrays.asList(31, 45, 30, 22, 21, 1);
        LottoTicket testLottoTicket = LottoTicket.newTicket(testTicket);

        LottoTicketCreatable lottoTicketCreatable = new LottoTicketCreatable() {
            @Override
            public LottoTicket createTicket() {
                return testLottoTicket;
            }

            @Override
            public LottoTickets createTickets(int purchaseCount) {
                List<LottoTicket> ticketList = new ArrayList<>();
                for (int i = 0; i < purchaseCount; i++) {
                    ticketList.add(createTicket());
                }

                return LottoTickets.newTickets(ticketList);
            }
        };

        LottoTickets lottoTickets = lottoTicketCreatable.createTickets(1);
        List<Integer> lastWeeksWinningNumbers = Arrays.asList(1, 31, 35, 22, 5, 6);
        int bonusNumber = 5;

        // when
        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers, bonusNumber);
        LottoGame expectLottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers, bonusNumber);

        // then
        assertThat(lottoGame).isEqualTo(expectLottoGame);
    }
}