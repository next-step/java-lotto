package lotto;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {


    @Test
    public void 받은가격_만큼의_로또티켓_생성() {
        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumGenerator());
        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(2000);
        assertThat(lottoTickets.size()).isEqualTo(2);
    }
}