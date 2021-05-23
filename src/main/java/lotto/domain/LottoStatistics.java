package lotto.domain;

import java.util.Map;

public class LottoStatistics {
    public static final int WINNING_NUMBER_MINIMUM = 3;
    public static final int WINNING_NUMBER_MAXIMUM = 6;
    private static final int DEFAULT_COUNT = 0;
    private static final int ONE_HUNDRED_INT = 100;
    private static final double ONE_HUNDRED_DOUBLE = 100.0;
    private final Map<Integer, Integer> matchedCounts;

    public LottoStatistics(Map<Integer, Integer> matchedCounts) {
        validateMatchingNumber(matchedCounts);
        this.matchedCounts = matchedCounts;
    }

    public boolean isEmpty() {
        return this.matchedCounts.isEmpty();
    }

    public int getCountOfLottoWithMatchingNumber(int matchingNumber) {
        return this.matchedCounts.getOrDefault(matchingNumber, DEFAULT_COUNT);
    }

    public Long getTotalWinningAmount() {
        Long totalAmount = 0L;
        for (Integer matchingCount : this.matchedCounts.keySet()) {
            totalAmount += calculateAmountByMatchingCount(matchingCount);
        }
        return totalAmount;
    }

    public Double calculateRateOfReturnByPrice(Price price) {
        return ((double) getTotalWinningAmount() / (double) price.getPrice()) * ONE_HUNDRED_INT / ONE_HUNDRED_DOUBLE;
    }

    private long calculateAmountByMatchingCount(Integer matchingCount) {
        WinningAmount winningAmount = new WinningAmount();
        return this.matchedCounts.getOrDefault(matchingCount, DEFAULT_COUNT) * winningAmount.getAmount(matchingCount);
    }

    private void validateMatchingNumber(Map<Integer, Integer> matchedCounts) {
        boolean error = false;
        for (Integer matchingNumber : matchedCounts.keySet()) {
            error |= matchingNumber < WINNING_NUMBER_MINIMUM || matchingNumber > WINNING_NUMBER_MAXIMUM;
        }
        if (error) {
            throw new IllegalArgumentException("당첨을 인정하는 번호 일치 개수는 3~6개 입니다.");
        }
    }
}
