package model;

import java.util.HashMap;
import java.util.Map;

public class WinRule {
    private Map<Integer, Integer> winRule = new HashMap<Integer, Integer>();

    public WinRule() {
        for (Rank rank : Rank.values()) {
            this.winRule.put(rank.getCountOfMatch(), rank.getWinningMoney());
        }

    }

    public Map<Integer, Integer> getWinRule() {
        return winRule;
    }

}
