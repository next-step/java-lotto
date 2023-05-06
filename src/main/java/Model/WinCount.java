package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinCount {
    private Map<Integer, Integer> winCount = new HashMap<>();

    public WinCount(WinRule winRule, ArrayList<Lotto> lottos, WinNum winNum) {
        for (Lotto lotto : lottos) {
            int equalCount = getEqualCount(lotto.getLotto(), winNum.getWinNum());
            if (winRule.getWinRule().containsKey(equalCount)) {
                this.winCount.merge(equalCount, 1, Integer::sum);
            }
        }
    }

    public Map<Integer, Integer> getWinCount() {
        return this.winCount;
    }

    public int getEqualCount(ArrayList<Integer> inputNums, ArrayList<Integer> winLotto) {
        inputNums.retainAll(winLotto);

        int equalNum = inputNums.size();

        return equalNum;
    }
}
