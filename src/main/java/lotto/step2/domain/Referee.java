package lotto.step2.domain;

import lotto.step2.domain.dto.PaymentPriceDTO;
import lotto.step2.domain.dto.ToTalRewardDTO;

import java.util.List;
import java.util.stream.IntStream;

public class Referee {
    private static final TotalRewardCalculateMap TOTAL_REWARD_CALCULATE_MAP = new TotalRewardCalculateMap();
    private static final int NUMBER_OF_WINNING_CASES = 4;
    private static final int ZERO = 0;
    
    public static ToTalReward getTotalReward(List<MatchNumber> matchNumbers) {
        return new ToTalReward(TOTAL_REWARD_CALCULATE_MAP.totalReward(matchNumbers));
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
    
    public static WinsNumbers winsNumbers(List<MatchNumber> matchNumbers) {
        return new WinsNumbers(winsNumbersArray(matchNumbers));
    }
    
    private static int[] winsNumbersArray(List<MatchNumber> matchNumbers) {
        return IntStream.range(ZERO, NUMBER_OF_WINNING_CASES)
                .map(index -> winNumbersCalculate(index, matchNumbers))
                .toArray();
    }
    
    private static int winNumbersCalculate(int index, List<MatchNumber> matchNumbers) {
        return (int) matchNumbers.stream()
                .mapToInt(MatchNumber::getIndex)
                .filter(matchNumberIndex -> matchNumberIndex == index)
                .count();
    }
}
