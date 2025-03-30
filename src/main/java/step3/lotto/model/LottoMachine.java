package step3.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<LottoNumber> allLottoNumbers;

    public LottoMachine() {
        allLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            allLottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoTicketList buyLottoTickets(Money purchaseAmount) {
        Count ticketCount = new Count(purchaseAmount.value() / LottoTicket.PRICE.value());
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount.value(); i++) {
            lottoTickets.add(issueLottoTicket());
        }
        return new LottoTicketList(lottoTickets);
    }

    public LottoTicket issueLottoTicket() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lottoTicket = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoTicket.add(allLottoNumbers.get(i));
        }
        Collections.sort(lottoTicket);
        return new LottoTicket(lottoTicket);
    }

}
