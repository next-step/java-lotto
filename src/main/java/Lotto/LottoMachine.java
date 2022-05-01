package Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    private Map<Integer,Integer> winningRankMap = new HashMap<>();

    public LottoMachine(int [] winningRanks) {
        for(int rank : winningRanks) {
            addWinningRank(rank);
        }
    }

    public LottoMachine(Map<Integer, Integer> result) {
        winningRankMap = result;
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
        for (int rank : winningRankMap.keySet()) {
            sum = getWinningSumMoney(sum, rank);
        }

        return sum;
    }

    private int getWinningSumMoney(int sum, int rank) {
        if(winningRankMap.containsKey(rank)) {
            int winningNum = winningRankMap.get(rank);
            sum += WinningRankInfo.findWinningRank(rank).sum(winningNum);
        }

        return sum;
    }
}
