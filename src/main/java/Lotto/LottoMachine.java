package Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMachine {
    private final Map<String,Integer> winningRankMap = new HashMap<>();

    public LottoMachine() {
        this(new String[] {});
    }

    public LottoMachine(String [] winningRanks) {
        for(String rank : winningRanks) {
            addWinningRank(rank);
        }
    }

    private void addWinningRank(String rank) {
        if (!winningRankMap.containsKey(rank))
            winningRankMap.put(rank,1);
        else {
            int winningNum = winningRankMap.get(rank);
            winningRankMap.put(rank,winningNum + 1);
        }
    }

    public int getWinningSumPrice() {
        int sum = 0;
        for (String rank : winningRankMap.keySet()) {
            sum = getWinningSumMoney(sum, rank);
        }

        return sum;
    }

    private int getWinningSumMoney(int sum, String rank) {
        if(winningRankMap.containsKey(rank)) {
            int winningNum = winningRankMap.get(rank);
            sum += WinningSumMoney.findWinningRank(rank).sum(winningNum);
        }

        return sum;
    }
}
