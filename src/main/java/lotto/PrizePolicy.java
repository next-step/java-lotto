package lotto;

public enum PrizePolicy {
    THREE(3, 5000),   // 3개 일치
    FOUR(4, 50000),   // 4개 일치
    FIVE(5, 1500000), // 5개 일치
    SIX(6, 2000000000); // 6개 일치

    private final int matchCount;
    private final int prize;

    PrizePolicy(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static int fromMatchCount(int matchCount) {
        for (PrizePolicy policy : PrizePolicy.values()) {
            if (policy.getMatchCount() == matchCount) {
                return policy.getPrize();
            }
        }
        throw new IllegalArgumentException("유효하지 않은 매칭 숫자: " + matchCount);
    }
}
