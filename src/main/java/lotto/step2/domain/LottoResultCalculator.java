package lotto.step2.domain;

import java.util.List;

public class LottoResultCalculator {
    public static double parseYield(List<LottoRank> lottoRanks, PaymentInformation paymentInformation) {
        return (int) (((double) getTotalReward(lottoRanks) / paymentInformation.getPaymentPrice()) * 100) / 100.0;
    }
    
    private static int getTotalReward(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToInt(LottoRank::getReward)
                .sum();
    }
}
