package lotto.domain;

import lotto.strategy.AutoLottoStrategy;
import lotto.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    public static final int LOTTO_PRICE = 1000;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public static LottoTickets fromNumbers(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket());
        }
        return new LottoTickets(tickets);
    }

    public void generateAllLottoNumbers(AutoLottoStrategy autoLottoStrategy){
        lottoTickets.forEach(lottoTickets -> lottoTickets.generateLottoNumbers(autoLottoStrategy));
    public static LottoTickets purchase(int payment, LottoStrategy lottoStrategy) {
        int count = payment / LOTTO_PRICE;
        return fromNumbers(count, lottoStrategy);
    }
    }

}
