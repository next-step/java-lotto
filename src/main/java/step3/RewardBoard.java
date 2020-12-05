package step3;

import java.util.Arrays;

public enum RewardBoard {
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000),
    MISS(6, 0);

    private final int rank;
    private final int reward;
    public static int maxRank = 6;

    private RewardBoard(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public int getRank() {
        return this.rank;
    }

    public int getReward() {
        return this.reward;
    }

    public static RewardBoard getReward(int inputRank) {
        return Arrays.stream(values())
                .filter(reward -> reward.rank == inputRank)
                .findFirst()
                .orElse(RewardBoard.MISS);
    }

    public static int getRankByWinningCnt(int winningCnt, boolean bonusNumberFlag) {
        if (winningCnt == 3) {
            return 5;
        }
        if (winningCnt == 4) {
            return 4;
        }
        if (winningCnt == 5 && !bonusNumberFlag) {
            return 3;
        }
        if (winningCnt == 5) {
            return 2;
        }

        if (winningCnt == 6) {
            return 1;
        }
        return 6;
    }

    public static int getWinningCntByRank(int rank) {
        if (rank == 1) {
            return 6;
        }

        if (rank == 3) {
            return 5;
        }

        if (rank == 4) {
            return 4;
        }

        return 3;
    }
}
