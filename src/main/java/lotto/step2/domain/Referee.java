package lotto.step2.domain;

import lotto.step2.domain.dto.PaymentPriceDTO;
import lotto.step2.domain.dto.ToTalRewardDTO;

import java.util.List;

public class Referee {
    private static final ResultMap resultMap = new ResultMap();
    
    public static ToTalReward getTotalReward(List<MatchNumber> matchNumbers) {
        return new ToTalReward(resultMap.totalReward(matchNumbers));
    }
    
    public static double yield(PaymentPriceDTO paymentPriceDTO, ToTalRewardDTO totalRewardDTO) {
        return (int) ((double) getTotalReward(totalRewardDTO) / getPaymentPrice(paymentPriceDTO) * 100) / 100.0;
    }
    
    private static int getTotalReward(ToTalRewardDTO totalRewardDTO) {
        return totalRewardDTO.getTotalReward();
    }
    
    private static int getPaymentPrice(PaymentPriceDTO paymentPriceDTO) {
        return paymentPriceDTO.getPaymentPrice();
    }
}
