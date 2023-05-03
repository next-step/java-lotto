package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinnerRule {
    private Map<Integer, Integer> winnerRule = new HashMap<Integer, Integer>();
    public WinnerRule() {
        this.winnerRule.put(3, 5000);
        this.winnerRule.put(4, 50000);
        this.winnerRule.put(5, 1500000);
        this.winnerRule.put(6, 2000000000);
    }

    public Map<Integer, Integer> getWinnerRule() {
        return winnerRule;
    }

    //return : 당첨금액
    public int getWinnerPrice(ArrayList<Integer> inputNums, ArrayList<Integer> winnerLotto) {
        inputNums.retainAll(winnerLotto);

        int equalNum = inputNums.size();

        if (winnerRule.get(equalNum) != null) {
            return winnerRule.get(equalNum);
        }

        return 0;
    }

}
