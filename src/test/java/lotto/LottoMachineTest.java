package lotto;

import lotto.domain.UserLottoTickets;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void 초기_로또_번호_생성_45개() {
        UserLottoTicketGenerator userLottoTicketGenerator = new UserLottoTicketGenerator();

        assertThat(userLottoTicketGenerator.getLottoNumbers().size()).isEqualTo(45);
    }

    @Test
    public void 받은가격_만큼의_로또티켓_생성() {
        int lottoPrice = 1000;
        int expectUser1TicketCount = 10;
        int expectUser2TicketCount = 2;

        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());
        UserLottoTickets userLottoTickets = lottoMachine.buyLottoTicket(new Money(expectUser1TicketCount*lottoPrice));
        UserLottoTickets userLottoTickets2 = lottoMachine.buyLottoTicket(new Money(expectUser2TicketCount*lottoPrice));

        assertThat(userLottoTickets.getUserLottoTickets().size()).isEqualTo(expectUser1TicketCount);
        assertThat(userLottoTickets2.getUserLottoTickets().size()).isEqualTo(expectUser2TicketCount);
    }
}