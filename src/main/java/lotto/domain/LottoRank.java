package lotto.domain;

public enum LottoRank {
    MATCH_3(3, 5_000, "3개 일치 (5000원)"),
    MATCH_4(4, 50_000, "4개 일치 (50000원)"),
    MATCH_5(5, 1_500_000, "5개 일치 (1500000원)"),
    MATCH_6(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    NO_MATCH(0, 0, "NO_MATCH");
    ;

    private final int match;
    private final int money;
    private final String description;

    LottoRank(int match, int money, String description) {
        this.match = match;
        this.money = money;
        this.description = description;
    }

    public static LottoRank fromMatch(int match) {
        for(LottoRank rank: LottoRank.values()) {
            if (rank.match == match) {
                return rank;
            }
        }

        return NO_MATCH;
    }

    public int money() {
        return this.money;
    }

    public String description() { return this.description; }
}
