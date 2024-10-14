package lotto.constants;

import java.util.Arrays;

public enum LottoRank {

      FIRST_PRIZE ("6", "1등", 2000000000)
    , SECOND_PRIZE ("5", "2등", 1500000)
    , THIRD_PRIZE ("4", "3등", 50000)
    , FOURTH_PRIZE ("3", "4등", 5000)
    , NON_WINNER ("0", "낙첨", 0);

    private String count;
    private String rank;
    private long amount;

    LottoRank(String count, String rank, long amount) {
        this.count = count;
        this.rank = rank;
        this.amount = amount;
    }

    public String getCount() {
        return count;
    }

    public String getRank() {
        return rank;
    }

    public long getAmount() {
        return amount;
    }

    static public LottoRank findByCount(String value) {

        if (value.equals("0") || value.equals("1") || value.equals("2")) {
            return NON_WINNER;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.getCount().contains(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 등수가 없습니다."));
    }

}
