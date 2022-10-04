package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);
    
    private final int reward;
    private final int countOfMatchNumber;
    
    LottoRank(int countOfMatchNumber, int reward) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.reward = reward;
    }
    
    public static LottoRank valueOf(Integer countOfMatchNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.countOfMatchNumber == countOfMatchNumber)
                .findAny()
                .orElse(MISS);
    }
    
    public int getReward() {
        return reward;
    }
    
    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
    
    public int getCountOfLottoRanks(List<LottoRank> lottoRanks) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> this == lottoRank)
                .count();
    }
}
