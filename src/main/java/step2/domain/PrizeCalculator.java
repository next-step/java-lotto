package step2.domain;

import java.util.List;
import java.util.Map;

public class PrizeCalculator {

    public double calculateProfitRatio(List<LottoTicket> tickets, int amount){
        double totalPrize = 0;

        for(LottoTicket ticket : tickets){
            totalPrize = sumPrize(totalPrize, ticket);
        }

        return amount == 0 ? 0 : totalPrize/amount;
    }

    private double sumPrize(double totalPrize, LottoTicket lottoTicket){
        totalPrize = totalPrize + lottoTicket.getPrizeResult();
        return totalPrize;
    }

}
