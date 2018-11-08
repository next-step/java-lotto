package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final LottoTicketGenerator lottoTicketGenerator;
    private final int LOTTO_PRICE = 1000;
    
    public LottoStore(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator; 
    }

    public List<LottoTicket> buy(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("로또 한개당 가격은 %d원입니다.", LOTTO_PRICE));
        }
        
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            tickets.add(generateLottoTicket());
        }
        
        return tickets;
    }

    private LottoTicket generateLottoTicket() {
        return lottoTicketGenerator.generate();
    }

}
