package step2.domain;

import java.util.Arrays;
import java.util.Map;

public enum Prize {
    THREE(3){
        @Override
        public int getReward() {
            return 5000;
        }
    },
    FOUR(4) {
        @Override
        public int getReward() {
            return 50000;
        }
    },
    FIVE(5){
        @Override
        public int getReward(){
            return 1500000;
        }
    },
    SIX(6) {
        @Override
        public int getReward() {
            return 2000000000;
        }
    };

    private final int matchCount;

    public abstract int getReward();

    Prize(int matchCount){
        this.matchCount = matchCount;
    }

    public static int calculateTotalIncome(final Map<Prize, Integer> drawLottoResult){
        int totalReward = 0;
        for (Prize prize: drawLottoResult.keySet()) {
            totalReward += prize.getReward();
        }
        return totalReward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Prize getPrize(int matchCount) {
        if (matchCount > 6) {
            throw new IllegalArgumentException("6개 이상 당첨될 수 없습니다.");
        }

        return Arrays.stream(Prize.values())
            .filter(prize -> prize.getMatchCount() == matchCount)
            .findAny()
            .get();
    }
}
