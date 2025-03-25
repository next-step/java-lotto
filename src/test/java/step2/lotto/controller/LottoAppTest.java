package step2.lotto.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.model.Count;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;

public class LottoAppTest {

    @Test
    @DisplayName("로또 구입 테스트")
    void givenPurchaseAmount_whenBuyLotto_thenSuccess() {
        // given
        String purchaseAmount = "1000";

        // when
        LottoApp lottoApp = new LottoApp();
        LottoTicketList lottoTicketList = lottoApp.buyLottoTickets(new Money(purchaseAmount));

        // then
        assertThat(lottoTicketList.value().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("맞춘 로또 개수 테스트 #1")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount1_thenSuccess() {
        // given
        LottoApp lottoApp = new LottoApp();
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("6, 7, 8, 9, 10, 11");

        // when
        assertThat(lottoApp.isLottoTicketMatchTargetCount(lastWeekWinningTicket, lottoTicket, new Count(1)))

            // then
            .isTrue();
    }

    @Test
    @DisplayName("맞춘 로또 개수 테스트 #2")
    void givenLottoTickets_whenCalculateLottoTicketsCountOfMatchTargetCount2_thenSuccess() {
        // given
        LottoApp lottoApp = new LottoApp();
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket lastWeekWinningTicket = new LottoTicket("5, 6, 7, 8, 9, 10");

        // when
        assertThat(lottoApp.isLottoTicketMatchTargetCount(lastWeekWinningTicket, lottoTicket, new Count(2)))

            // then
            .isTrue();
    }

}
