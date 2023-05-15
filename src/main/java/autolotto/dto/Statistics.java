package autolotto.dto;

import java.util.Map;

public class Statistics {
    private final String profitRate;
    private final Map<Integer, Integer> countOfEachMatchingNumber;

    public Statistics(String profitRate, Map<Integer, Integer> countOfEachMatchingNumber) {
        this.profitRate = profitRate;
        this.countOfEachMatchingNumber = countOfEachMatchingNumber;
    }

    public String profitRate() {
        return this.profitRate;
    }

    public Map<Integer, Integer> countOfEachMatchingNumber() {
        return this.countOfEachMatchingNumber;
    }
}
