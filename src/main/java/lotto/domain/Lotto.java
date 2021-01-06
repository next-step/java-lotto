package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 46;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoTicket generateLottoTicket() {
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(this.lottoNumbers.subList(0, LottoTicket.LOTTO_TICKET_NUMBER));
    }

    private List<LottoTicket> getLottoTicket(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    public List<LottoTicket> buyLottoTicket(int money) {
        int ticketCount = LottoTicket.countPurchasable(money);
        return getLottoTicket(ticketCount);
    }


}
