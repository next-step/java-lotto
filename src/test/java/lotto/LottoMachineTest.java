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
        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());
        UserLottoTickets userLottoTickets = lottoMachine.buyLottoTicket(new Money(10000));
        UserLottoTickets userLottoTickets2 = lottoMachine.buyLottoTicket(new Money(2000));

        assertThat(userLottoTickets.getUserLottoTickets().size()).isEqualTo(10);
        assertThat(userLottoTickets2.getUserLottoTickets().size()).isEqualTo(2);
    }
}