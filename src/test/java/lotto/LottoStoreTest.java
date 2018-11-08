package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LottoStoreTest {

    private LottoStore lottoStore = null;
    private LottoTicketGenerator lottoTicketGenerator = null;
    
    @Before
    public void setup() {
        lottoTicketGenerator = new LottoTicketGenerator();
        lottoStore = new LottoStore(lottoTicketGenerator);
    }
    
//    @Test
//    public void 로또_객체_확인() {
//        new LottoStore();
//    }
    
//    @Test
//    public void 로또_구입_매소드_확인() {
//        LottoGame lottoGame = new LottoGame();
//        lottoGame.buy(1000);
//    }
    
    @Test
    public void 로또_1000원_구입_확인() {
        // given
        int money = 1000;
        
        // when
        List<LottoTicket> tickets = lottoStore.buy(money);
        
        // then
        assertThat(tickets.size()).isEqualTo(1);
    }
    
    @Test
    public void 로또_3000원_구입_확인() {
        // given
        int money = 3000;
        
        // when
        List<LottoTicket> tickets = lottoStore.buy(money);
        
        // then
        assertThat(tickets.size()).isEqualTo(3);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void 로또_500원_구입_확인() {
        // given
        int money = 500;
        
        // when
        List<LottoTicket> tickets = lottoStore.buy(money);
        
        // then
        assertThat(tickets.size()).isEqualTo(0);
    }
}
