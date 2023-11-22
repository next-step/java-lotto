package lotto.domain;

import java.util.Arrays;
import lotto.domain.rank.BonusRank;
import lotto.domain.rank.FirstRank;
import lotto.domain.rank.FourthRank;
import lotto.domain.rank.NotRank;
import lotto.domain.rank.Rank;
import lotto.domain.rank.SecondRank;
import lotto.domain.rank.ThirdRank;

public enum Prize {
    EIGHTH(new NotRank(), 0),
    SEVENTH(new NotRank(), 0),
    FIFTH(new NotRank(), 0),
    FOURTH(new FourthRank(), 5_000),
    THIRD(new ThirdRank(), 50_000),
    SECOND(new SecondRank(), 1_500_000),
    FIRST(new FirstRank(), 2_000_000_000),
    BONUS(new BonusRank(), 30_000_000);

    private final Rank rank;
    private final int price;

    Prize(Rank rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public static Prize prizeByMatchedCount(int matchedCount) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.rank.integerEqualToRank(matchedCount))
            .findFirst()
            .get();
    }

    public Rank rank() {
        return rank;
    }

    public int price() {
        return price;
    }

    public void addScore(int score) {
        this.rank.addScore(score);
    }
}
