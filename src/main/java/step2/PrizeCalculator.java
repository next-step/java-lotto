package step2;

import java.util.List;

public class PrizeCalculator {

    public double calculateProfitRatio(List<LottoTicket> tickets, int amount) {
        double totalPrize = 0;

        for (LottoTicket ticket : tickets) {
            totalPrize = sumPrize(totalPrize, ticket);
        }

        return amount == 0 ? 0 : Math.floor(totalPrize / amount * 100) / 100.0;
    }

    private double sumPrize(double totalPrize, LottoTicket lottoTicket) {
        totalPrize = totalPrize + lottoTicket.getPrizeResult();
        return totalPrize;
    }
}
