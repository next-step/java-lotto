package lotto.step2.domain;

import java.util.List;

public class Referee {
    private final ResultMap resultMap;
    
    public Referee() {
        resultMap = new ResultMap();
    }
    
    public double yield(PaymentPrice paymentPrice, ToTalReward totalReward) {
        PaymentPriceDTO paymentPriceDTO = paymentPrice.paymentPriceInformation();
        ToTalRewardDTO toTalRewardDTO = totalReward.totalRewardInformation();
        int paymentPrice1 = paymentPriceDTO.getPaymentPrice();
        int totalReward1 = toTalRewardDTO.getTotalReward();
        return (int) ((double) totalReward1 / paymentPrice1 * 100) / 100.0;
    }
    
    private int getTotalReward(List<MatchNumber> matchNumbers) {
        return resultMap.totalReward(matchNumbers);
    }
}
