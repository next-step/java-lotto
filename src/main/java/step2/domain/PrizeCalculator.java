package step2.domain;

import java.util.Map;

public class PrizeCalculator {

    public double calculateProfitRatio(Map<Integer, Integer> winningTicketCategories, int amount){
        double totalPrize = 0;
        for(Map.Entry<Integer, Integer> entry : winningTicketCategories.entrySet()){
            totalPrize = sumPrize(totalPrize, entry);
        }

        return amount == 0 ? 0 : totalPrize/amount;
    }

    private double sumPrize(double totalPrize, Map.Entry<Integer, Integer> entry){
        totalPrize = totalPrize + entry.getKey() * entry.getValue();
        return totalPrize;
    }

}
