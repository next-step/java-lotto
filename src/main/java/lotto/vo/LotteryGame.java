package lotto.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryGame {
    List<Lottery> lotteries;
    Map<Rank, Integer> ranks;

    public LotteryGame(int tickets) {
        lotteries = new ArrayList<>();
        ranks = new HashMap<>();
        createTicket(tickets);
    }

    private void createTicket(int tickets) {
        for (int i = 0; i < tickets; i++) {
            lotteries.add(new LotteryGenerator().lotteryNumbers());
        }
    }

    public Map<Rank, Integer> getWinningStatistics(WinningNumber winningNumber) {
        for (int i = 0; i < lotteries.size(); i++) {
            Rank rank = winningNumber.match(lotteries.get(i));
            ranks.put(rank, getRanks(rank));
        }
        return ranks;
    }

    private int getRanks(Rank rank) {
        if (!ranks.containsKey(rank)) {
            return 1;
        }
        return ranks.get(rank) + 1;
    }
}
