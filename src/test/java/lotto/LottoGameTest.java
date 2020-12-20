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
        List<Number> testTicket = Arrays.asList(Number.newNumber(31),
                                                Number.newNumber(45),
                                                Number.newNumber(30),
                                                Number.newNumber(22),
                                                Number.newNumber(21),
                                                Number.newNumber(1));

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

        // when
        LottoTicket lottoTicket = LottoTicket.newTicket(Arrays.asList(Number.newNumber(31),
                                                                        Number.newNumber(45),
                                                                        Number.newNumber(30),
                                                                        Number.newNumber(22),
                                                                        Number.newNumber(21),
                                                                        Number.newNumber(6)));
        Number bonusNumber = Number.newNumber(5);
        LastWinningNumbers lastWeeksWinningNumbers = LastWinningNumbers.newWinningNumbers(lottoTicket, bonusNumber);

        LottoGame lottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers);
        LottoGame expectLottoGame = new LottoGame(lottoTickets, lastWeeksWinningNumbers);

        // then
        assertThat(lottoGame).isEqualTo(expectLottoGame);
    }
}