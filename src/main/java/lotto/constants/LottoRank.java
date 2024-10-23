package lotto.constants;

import java.util.Arrays;

public enum LottoRank {

      FIRST_PRIZE (6, "1", 2000000000, false)
    , SECOND_PRIZE (5, "2", 30000000, true)
    , THIRD_PRIZE (5, "3", 1500000, false)
    , FOURTH_PRIZE (4, "4", 50000, false)
    , FIFTH_PRIZE (3, "5", 5000, false)
    , NON_WINNER (0, "낙첨", 0, false);

    private final int count;
    private final String rank;
    private final long amount;
    private final boolean requireBonus;

    LottoRank(int count, String rank,
              long amount,
              boolean requireBonus) {
        this.count = count;
        this.rank = rank;
        this.amount = amount;
        this.requireBonus = requireBonus;
    }

    public int getCount() {
        return count;
    }

    public String getRank() {
        return rank;
    }

    public long getAmount() {
        return amount;
    }

    public boolean isRequireBonus() {
        return requireBonus;
    }

    static public LottoRank findByCount(int count, boolean matchedBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.getCount() == count && (!rank.isRequireBonus() || matchedBonus))
                .findFirst()
                .orElse(NON_WINNER);
    }

}
