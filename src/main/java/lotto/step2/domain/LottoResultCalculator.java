package lotto.step2.domain;

import java.util.List;

public class LottoResultCalculator {
    public static double parseYield(List<LottoRank> lottoRanks, PaymentPrice paymentPrice) {
        return (int) (((double) getTotalReward(lottoRanks) / paymentPrice.getPaymentPrice()) * 100) / 100.0;
    }
    
    private static int getTotalReward(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToInt(LottoRank::getReward)
                .sum();
    }
}
