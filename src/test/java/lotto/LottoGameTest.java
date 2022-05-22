package lotto;

import lotto.model.LottoGame;
import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @Test
    void 로또_티켓_리스트_생성(){
        Money money = new Money(3000);

        List<LottoTicket> manualLottoTicketList = List.of(
                new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new Integer[]{11, 12, 13, 14, 15, 16}),
                new LottoTicket(new Integer[]{11, 12, 13, 14, 15, 16})
        );

        LottoTickets lottoTickets = LottoGame.generateLottoTickets(manualLottoTicketList, money);

        assertThat(lottoTickets.getManualLottoSize()).isEqualTo(3);
        assertThat(lottoTickets.getAutoTicketSize()).isEqualTo(0);
    }


    @Test
    @DisplayName("생성가능한 수동 로또 티켓 수보다 많이 생성했을 때 예외를 던진다.")
    void 로또_티켓_생성_예외(){
        Money money = new Money(3000);
        List<LottoTicket> manualLottoTicketList = List.of(
                new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new Integer[]{11, 12, 13, 14, 15, 16}),
                new LottoTicket(new Integer[]{11, 12, 13, 14, 15, 16})
        );

        assertThatThrownBy(()->{
            LottoGame.generateLottoTickets(manualLottoTicketList, money);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}