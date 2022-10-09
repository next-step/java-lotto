package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);
    
    private final int reward;
    private final int countOfMatchNumber;
    
    LottoRank(int countOfMatchNumber, int reward) {
        this.countOfMatchNumber = countOfMatchNumber;
        this.reward = reward;
    }
    
    public static LottoRank valueOf(Integer countOfMatchNumber, Boolean isExistBonusLottoNumber) {
        if (SECOND.countOfMatchNumber == countOfMatchNumber && isExistBonusLottoNumber) {
            return SECOND;
        }
        
        return parseLottoRank(countOfMatchNumber);
    }
    
    private static LottoRank parseLottoRank(Integer countOfMatchNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.countOfMatchNumber == countOfMatchNumber)
                .findAny()
                .orElse(MISS);
    }
    
    public int getCountOfLottoRanks(List<LottoRank> lottoRanks) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> this == lottoRank)
                .count();
    }
    
    public int getReward() {
        return reward;
    }
    
    public int getCountOfMatchNumber() {
        return countOfMatchNumber;
    }
}
