package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinRule {
    private Map<Integer, Integer> winRule = new HashMap<Integer, Integer>();

    public WinRule() {
        this.winRule.put(3, 5000);
        this.winRule.put(4, 50000);
        this.winRule.put(5, 1500000);
        this.winRule.put(6, 2000000000);
    }

    public Map<Integer, Integer> getWinRule() {
        return winRule;
    }

}
