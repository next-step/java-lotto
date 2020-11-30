package lotto.model;

import java.util.EnumMap;


public class Lotto {
    private final LottoTickets lottoTickets;
    private final int ticketPrice = 1000;
    private final int ticketCount;

    public Lotto(int money){
        this.ticketCount = money / ticketPrice;
        this.lottoTickets = LottoTickets.of(ticketCount);
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
