package lotto.service;

import lotto.dto.Rank;
import java.util.Map;

public class LottoResult {

    public static final int STANDARD = 1;
    public static final String MINUS_PROFIT = "손해";
    public static final String PLUS_PROFIT = "이익";
    public static final String SAME_PROFIT = "본전";

    int inputMoney;
    Map<Rank, Integer> maps;

    public LottoResult(int inputMoney, Map<Rank, Integer> maps) {
        this.inputMoney = inputMoney;
        this.maps = maps;
    }

    public String getProfitMessage(double res){
        if(isLow(res)){
            return MINUS_PROFIT;
        }
        if(isGreater(res)){
            return PLUS_PROFIT;
        }
        return SAME_PROFIT;
    }

    private boolean isLow(double res) {
        return res < STANDARD;
    }

    private boolean isGreater(double res) {
        return res > STANDARD;
    }

    public double profit(){
        int sum = 0;
        for(Rank rank : maps.keySet()){
            sum += rank.reward(maps.get(rank));
        }
        return sum/this.inputMoney;
    }
}
