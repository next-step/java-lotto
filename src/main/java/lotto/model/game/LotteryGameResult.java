package lotto.model.game;

import lotto.model.domain.Winning;

import java.util.ArrayList;
import java.util.List;

public class LotteryGameResult {

    private final int amount;
    private static final double LOSS_STANDARD = 1;

    public LotteryGameResult(int amount) {
        this.amount = amount;
    }

    public List<String> get() {
        List<String> result = new ArrayList<String>();
        for(Winning winning : Winning.values()){
            result.add(winning.print());
        }
        result.add(getProfitResult());
        return result;
    }

    private String getProfitResult(){
        double profit = Winning.getProfit(this.amount);
        String profitString = String.format("총 수익률은 %.2f 입니다.", profit);
        String isLossString = isLoss(profit) ? "손해" : "이익";
        return profitString + "(기준이 1이기 때문에 결과적으로 " + isLossString + "라는 의미임)";
    }

    private boolean isLoss(double profit) {
        return profit < LOSS_STANDARD;
    }
}