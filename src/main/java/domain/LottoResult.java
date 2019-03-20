package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private int numberOfMatch;
    private int profitMoney;
    private int count;

    final static private Map<Integer, Integer> PROFIT_VALUE;
    static {
        PROFIT_VALUE = new HashMap<>();
        PROFIT_VALUE.put(0,0);
        PROFIT_VALUE.put(1,0);
        PROFIT_VALUE.put(2,0);
        PROFIT_VALUE.put(3,5000);
        PROFIT_VALUE.put(4,50000);
        PROFIT_VALUE.put(5,1500000);
        PROFIT_VALUE.put(6,2000000000);
    }

    public LottoResult(int numberOfMatch, int count){
        this.numberOfMatch = numberOfMatch;
        this.count = count;

        this.profitMoney = PROFIT_VALUE.get(numberOfMatch);
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getProfitMoney() {
        return profitMoney;
    }

    public int getCount() {
        return count;
    }
}
