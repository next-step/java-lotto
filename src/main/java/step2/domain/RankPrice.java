package step2.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum RankPrice {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000);

    final private int match_number;
    final private int wined_money;

    RankPrice(int match_number, int wined_money) {
        this.match_number = match_number;
        this.wined_money = wined_money;
    }

    public static RankPrice valueOf(int countOfMatch, boolean matchBonus) {
        RankPrice Rank = Arrays.stream(RankPrice.values())
                .filter(rank -> rank.getMatchNumber() == countOfMatch)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        if (Rank.getMatchNumber() == 5 && matchBonus) {
            return RankPrice.SECOND_PLACE;
        }

        return Rank;
    }

    public static RankPrice valueOf(int countOfMatch) {
        RankPrice Rank = Arrays.stream(RankPrice.values())
                .filter(rank -> rank.getMatchNumber() == countOfMatch)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        return Rank;
    }

    public int getMatchNumber() {
        return match_number;
    }

    public int getWinedMoney() {
        return wined_money;
    }
}
