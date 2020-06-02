package study.step2.dto;

import java.util.List;

public class LottoGameRequestDto {

    private final List<Integer> matchingCounts;
    private final double earningsRate;

    public LottoGameRequestDto(List<Integer> matchingCounts, double earningsRate) {
        this.matchingCounts = matchingCounts;
        this.earningsRate = earningsRate;
    }

    public List<Integer> getMatchingCounts() {
        return matchingCounts;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
