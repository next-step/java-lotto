package step3.domain;

import step2.domain.LottoTicket;

import java.util.List;

public class ProfitCalculator {

    public double calculateProfitRatio(List<WinningType> winningTypes, int amount){
        if(amount == 0){
            return 0;
        }
        int totalPrize = 0;

        for(WinningType winningType : winningTypes){
            totalPrize = sumPrize(totalPrize, winningType);
        }

        return totalPrize/amount;
    }

    private int sumPrize(int totalPrize, WinningType winningType){
        totalPrize += winningType.getPrize();
        return totalPrize;
    }

}
