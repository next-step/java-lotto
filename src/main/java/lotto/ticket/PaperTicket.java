package lotto.ticket;

import lotto.Lotto;
import lotto.LottoNumbers;

import java.util.List;

public class PaperTicket implements Ticket {
    @Override
    public List<LottoNumbers> generateTickets(int count) {
        Lotto lotto = new Lotto();
        return lotto.makeLottoNumbers(count);
    }
}
