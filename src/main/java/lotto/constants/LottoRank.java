package lotto.constants;

import java.util.Arrays;

public enum LottoRank {

      FIRST_PRIZE (6, "1", 2000000000)
    , SECOND_PRIZE (5, "2", 1500000)
    , THIRD_PRIZE (4, "3", 50000)
    , FOURTH_PRIZE (3, "4", 5000)
    , NON_WINNER (0, "낙첨", 0);

    private int count;
    private String rank;
    private long amount;

    LottoRank(int count, String rank, long amount) {
        this.count = count;
        this.rank = rank;
        this.amount = amount;
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

    static public LottoRank findByCount(int count) {

        if (count >= 0 && count <= 2) {
            return NON_WINNER;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getCount() == count)
                .findFirst()
                .orElse(NON_WINNER);
    }

}
