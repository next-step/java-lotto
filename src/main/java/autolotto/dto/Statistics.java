package autolotto.dto;

import java.util.Map;

public class Statistics {
    private final String profitRate;
    private final Map<WinningAmount, Integer> countOfEachMatchingNumber;

    public Statistics(String profitRate, Map<WinningAmount, Integer> countOfEachMatchingNumber) {
        this.profitRate = profitRate;
        this.countOfEachMatchingNumber = countOfEachMatchingNumber;
    }

    public String profitRate() {
        return this.profitRate;
    }

    public Map<WinningAmount, Integer> countOfEachMatchingNumber() {
        return this.countOfEachMatchingNumber;
    }
}
