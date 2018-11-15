package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lottoMachine.AutoLottoMachine;
import lotto.domain.lottoMachine.DefaultLottoMachine;
import lotto.domain.lottoMachine.ManualLottoMachine;

import org.junit.Before;
import org.junit.Test;

public class LottoStoreTest {

    private LottoStore lottoStore = null;
    
    @Before
    public void setup() {
        lottoStore = new LottoStore(new DefaultLottoMachine(new AutoLottoMachine(), new ManualLottoMachine()));
    }
    
    @Test
    public void 로또_1000원_구입_확인() {
        // when
        LottoTicket tickets = lottoStore.buyTickets(new LottoRequest(Money.of(1000)));
        
        // then
        assertThat(tickets.getAutoLottoCount()).isEqualTo(1);
    }
    
    @Test
    public void 로또_3000원_구입_확인() {
        // when
        LottoTicket tickets = lottoStore.buyTickets(new LottoRequest(Money.of(3000)));
        
        // then
        assertThat(tickets.getAutoLottoCount()).isEqualTo(3);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void 로또_500원_구입_확인() {
        // when
        LottoTicket tickets = lottoStore.buyTickets(new LottoRequest(Money.of(500)));
        
        // then
        assertThat(tickets.getAutoLottoCount()).isEqualTo(0);
    }
}
