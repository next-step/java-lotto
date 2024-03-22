package lotto.domian;

import static lotto.common.ConstantSet.LOTTO_TICKET_PRICE;
import static lotto.common.MessageSet.NOT_ENOUGH_MONEY;

public class LottoShop {

    LottoNumberGenerator generator ;

    private LottoShop(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public static LottoShop of(LottoNumberGenerator generator){
        return new LottoShop(generator);
    }

    public LottoTickets generateLottoTickets(int money){
        int ticketCount = getPurchasableTicketCount(money);
        return LottoTickets.of(ticketCount,generator);
    }

    private int getPurchasableTicketCount(int money) {
        return money/LOTTO_TICKET_PRICE;
    }

}
