package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningMoney {
    private final Map<Integer, Integer> winningMoney = new HashMap<>();

    public WinningMoney(){
        winningMoney.put(3, 5000);
        winningMoney.put(4, 50000);
        winningMoney.put(5, 1500000);
        winningMoney.put(6, 2000000000);
    }

    public int winningMoneyOf(int matchCount){
        return winningMoney.get(matchCount);
    }
}
