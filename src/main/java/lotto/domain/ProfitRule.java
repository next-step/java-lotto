package lotto.domain;

public enum ProfitRule {

    MATCHED_3(3L, 5000),
    MATCHED_4(4L, 50000),
    MATCHED_5(5L, 1500000),
    MATCHED_6(6L, 2000000000);

    Long matchingScore;
    int profit;

    ProfitRule(long matchingScore, int profit) {
        this.matchingScore = matchingScore;
        this.profit = profit;
    }

    public Long getMatchingScore() {
        return matchingScore;
    }

    public int getProfit() {
        return profit;
    }

    public static ProfitRule getProfitByMatchingScore(Long matchingScore) {
       for (ProfitRule p :ProfitRule.values()) {
           if (p.getMatchingScore().compareTo(matchingScore) == 0) {
               return p;
           }
       }
        throw new IllegalArgumentException(matchingScore + "개 일치한 경우는 profit이 없습니다.");
    }
}
