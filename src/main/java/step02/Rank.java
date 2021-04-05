package step02;

import static step02.LottoConfig.ONE_HUNDRED;
import static step02.LottoConfig.ONE_HUNDRED_D;

public class Rank {
    enum RANK {
        FIRST(6, 2000000000),
        SECOND(5, 1500000),
        THIRD(4, 50000),
        FOURTH(3, 5000);

        private final int matchCount;
        private final int reward;

        RANK(int matchCount, int reward) {
            this.matchCount = matchCount;
            this.reward = reward;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getReward() {
            return reward;
        }

        public static int calculate(String rank, int count) {
            return valueOf(rank).reward * count;
        }
    }


    public static double calculateTotalReward(int money, LottoResultDTO lottoResultDTO) {
        int totalReward = 0;
        totalReward += RANK.calculate(RANK.FIRST.name(), lottoResultDTO.getMath6());
        totalReward += RANK.calculate(RANK.SECOND.name(), lottoResultDTO.getMath5());
        totalReward += RANK.calculate(RANK.THIRD.name(), lottoResultDTO.getMath4());
        totalReward += RANK.calculate(RANK.FOURTH.name(), lottoResultDTO.getMath3());

        return calculateYield(money, totalReward);
    }

    private static double calculateYield(int money, int totalReward) {
        return Math.round((totalReward / (double) money) * ONE_HUNDRED) / ONE_HUNDRED_D;
    }


}