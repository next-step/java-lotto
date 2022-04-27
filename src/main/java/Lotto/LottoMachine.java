package Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    private final Map<Integer,Integer> winningRankMap = new HashMap<>();

    public LottoMachine() {
        this(new int[] {});
    }

    public LottoMachine(int [] winningRanks) {
        for(int rank : winningRanks) {
            addWinningRank(rank);
        }
    }

    private void addWinningRank(int rank) {
        if (!winningRankMap.containsKey(rank))
            winningRankMap.put(rank,1);
        else {
            int winningNum = winningRankMap.get(rank);
            winningRankMap.put(rank,winningNum + 1);
        }
    }

    public int getWinningSumPrice() {
        int sum = 0;
        for (Integer key : winningRankMap.keySet()) {
            if(winningRankMap.containsKey(key)) {
                int winningNum = winningRankMap.get(key);
                if (key == 1) {
                    sum += (2000000000 * winningNum);
                }
                if (key == 2) {
                    sum += (1500000 * winningNum);
                }
                if (key == 3) {
                    sum += (50000 * winningNum);
                }
                if (key == 4) {
                    sum += (5000 * winningNum);
                }
            }
        }

        return sum;
    }
}
