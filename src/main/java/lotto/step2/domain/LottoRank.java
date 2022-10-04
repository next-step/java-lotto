package lotto.step2.domain;

import lotto.step2.dto.PaymentPriceDTO;

import java.util.*;

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
    
    public static double getYield(List<LottoRank> lottoRanks, PaymentPriceDTO paymentPriceDTO) {
        return (int)(((double) getTotalReward(lottoRanks) / paymentPriceDTO.getPaymentPrice()) * 100) / 100.0;
    }
    
    public static int getTotalReward(List<LottoRank> lottoRankList) {
        return lottoRankList.stream()
                .mapToInt(LottoRank::getReward)
                .sum();
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
