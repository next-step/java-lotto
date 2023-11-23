package lotto.domain;

import java.util.Arrays;
import lotto.domain.rank.FirstRank;
import lotto.domain.rank.FourthRank;
import lotto.domain.rank.NotRank;
import lotto.domain.rank.Rank;
import lotto.domain.rank.SecondRank;
import lotto.domain.rank.ThirdRank;

public enum Prize {
    NOT_RANK(new NotRank(), 0),
    FOURTH(new FourthRank(), 5_000),
    THIRD(new ThirdRank(), 50_000),
    SECOND(new SecondRank(), 1_500_000),
    BONUS(new NotRank(), 3_000_000),
    FIRST(new FirstRank(), 2_000_000_000);

    private final Rank rank;
    private final int price;

    Prize(Rank rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public static void applyPrize(WinningLotto winningLotto, Lotto lotto) {
        Arrays.stream(Prize.values())
            .forEach(prize -> {
                prize.rank().apply(winningLotto, lotto);
            });
    }

    public Rank rank() {
        return rank;
    }

    public int price() {
        return price;
    }

}
