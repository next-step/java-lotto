package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinners {
    private static final int REWARD_4TH = 5000;
    private static final int REWARD_3RD = 50000;
    private static final int REWARD_2ND = 1500000;
    private static final int REWARD_1ST = 2000000000;
    Map<Integer, Integer> winner = new HashMap<>();

    public LottoWinners() {
        winner.put(REWARD_1ST, 0);
        winner.put(REWARD_2ND, 0);
        winner.put(REWARD_3RD, 0);
        winner.put(REWARD_4TH, 0);
    }

    public void refresh(int count) {
        switch (count) {
            case 3:
                winner.put(REWARD_4TH, winner.get(REWARD_4TH) + 1);
                break;
            case 4:
                winner.put(REWARD_3RD, winner.get(REWARD_3RD) + 1);
                break;
            case 5:
                winner.put(REWARD_2ND, winner.get(REWARD_2ND) + 1);
                break;
            case 6:
                winner.put(REWARD_1ST, winner.get(REWARD_1ST) + 1);
                break;
        }
    }

    public int count(Rank rank) {
        if (rank == Rank.POSTION_1)
            return winner.get(REWARD_1ST);
        if (rank == Rank.POSTION_2)
            return winner.get(REWARD_2ND);
        if (rank == Rank.POSTION_3)
            return winner.get(REWARD_3RD);
        if (rank == Rank.POSTION_4)
            return winner.get(REWARD_4TH);

        return 0;
    }

    public int totalMoney() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += count(rank) * rank.price;
        }
        return total;
    }
}
