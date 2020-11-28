package lotto.domain;

public enum ProfitRule {

    MATCHED_3(3L, 5000, "3개 일치"),
    MATCHED_4(4L, 50000, "4개 일치"),
    MATCHED_5(5L, 1500000, "5개 일치"),
    MATCHED_6(6L, 2000000000, "6개 일치");

    Long matchingScore;
    int profit;
    String desc;

    ProfitRule(long matchingScore, int profit, String desc) {
        this.matchingScore = matchingScore;
        this.profit = profit;
        this.desc = desc;
    }

    public Long getMatchingScore() {
        return matchingScore;
    }

    public int getProfit() {
        return profit;
    }

    public String getDesc() {
        return desc;
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
