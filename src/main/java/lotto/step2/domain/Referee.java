package lotto.step2.domain;

import lotto.step2.domain.dto.PaymentPriceDTO;
import lotto.step2.domain.dto.ToTalRewardDTO;

import java.util.List;

public class Referee {
    private static final ResultMap resultMap = new ResultMap();
    
    public static double yield(PaymentPrice paymentPrice, ToTalReward totalReward) {
        return (int) ((double) getTotalReward(totalReward) / getPaymentPrice(paymentPrice) * 100) / 100.0;
    }
    
    private static int getTotalReward(ToTalReward totalReward) {
        return getToTalRewardDTO(totalReward).getTotalReward();
    }
    
    private static int getPaymentPrice(PaymentPrice paymentPrice) {
        return getPaymentPriceDTO(paymentPrice).getPaymentPrice();
    }
    
    private static ToTalRewardDTO getToTalRewardDTO(ToTalReward totalReward) {
        return totalReward.totalRewardInformation();
    }
    
    private static PaymentPriceDTO getPaymentPriceDTO(PaymentPrice paymentPrice) {
        return paymentPrice.paymentPriceInformation();
    }
    
    private static int getTotalReward(List<MatchNumber> matchNumbers) {
        return resultMap.totalReward(matchNumbers);
    }
}
