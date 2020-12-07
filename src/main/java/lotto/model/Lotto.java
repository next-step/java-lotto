package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public class Lotto {
    private final LottoTickets lottoTickets;
    private final int ticketPrice = 1000;
    private Map<String, Integer> ticketCountMap;

    public Lotto(int money, String[] manualNumbers){
        this.ticketCountMap = new HashMap<>();
        this.ticketCountMap.put("AUTO",(money / ticketPrice) - manualNumbers.length);
        this.ticketCountMap.put("MANUAL", manualNumbers.length);

        this.lottoTickets = LottoTickets.of(this.ticketCountMap.get("AUTO"), manualNumbers);
    }

    public int getAutoTicketCount(){
        return ticketCountMap.get("AUTO");
    }

    public int getManualTicketCount(){
        return ticketCountMap.get("MANUAL");
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
