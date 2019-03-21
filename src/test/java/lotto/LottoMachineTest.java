package lotto;

import org.junit.Test;

import java.util.List;

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
        List<LottoTicket> buyLottoTicket1 = lottoMachine.buyLottoTicket(2000);
        List<LottoTicket> buyLottoTicket2 = lottoMachine.buyLottoTicket(10000);
        assertThat(buyLottoTicket1.size()).isEqualTo(2);
        assertThat(buyLottoTicket2.size()).isEqualTo(10);
    }
}