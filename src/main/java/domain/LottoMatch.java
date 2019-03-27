package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatch {
    private int numberOfMatch;
    private int profitMoney;

    final static private Map<Integer, Integer> PROFIT_VALUE;
    static {
        PROFIT_VALUE = new HashMap<>();
        PROFIT_VALUE.put(0, 0);
        PROFIT_VALUE.put(1, 0);
        PROFIT_VALUE.put(2, 0);
        PROFIT_VALUE.put(3, 5000);
        PROFIT_VALUE.put(4, 50000);
        PROFIT_VALUE.put(5, 1500000);
        PROFIT_VALUE.put(6, 2000000000);
    }

    public LottoMatch(WinningLotto winningLotto, Lotto userLotto){
        this.numberOfMatch = winningLotto.match(userLotto);
        this.profitMoney = PROFIT_VALUE.get(numberOfMatch);
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

}
