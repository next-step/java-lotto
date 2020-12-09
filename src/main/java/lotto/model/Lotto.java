package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public class Lotto {
    private final LottoTickets lottoTickets;
    private final int ticketPrice = 1000;
    private int ticketCount;

    public Lotto(int money, String[] manualNumbers){
        this.ticketCount = money / ticketPrice;
        this.lottoTickets = LottoTickets.of(ticketCount - manualNumbers.length, manualNumbers);
    }

    public LottoTickets getLottoTickets(){
        return lottoTickets;
    }

    public double resultBenefit(EnumMap<Rank, Integer> winningStatics) {
        double price = 0;
        for(Rank rank : Rank.values()){
            price += (double)winningStatics.get(rank);
        }
        return price;
    }
}
