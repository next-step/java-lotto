package lotto.step3.enums;

import lotto.step3.domain.Result;
import lotto.step3.domain.TotalReturn;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    MISS(0, 0, "낙첨(0원)- "),
    FIFTH(5, 5_000, "3개 일치 (5,000원)- "),
    FOURTH(4, 50_000, "4개 일치 (50,000원)- "),
    THIRD(3, 1_500_000, "5개 일치 (1,500,000원)- "),
    SECOND(2, 30_000_000, "5개 일치, 보너스 볼 일치(30,000,000원)- "),
    FIRST(1, 200_000_000, "6개 일치 (2,000,000,000원)- ");

    private final int rank;
    private final int prize;
    private final String text;

    Rank(int rank, int prize, String text) {
        this.rank = rank;
        this.prize = prize;
        this.text = text;
    }

    public static Optional<Rank> of(int rank) {
        return Arrays.stream(values())
                .filter(r -> r.rank == rank)
                .findFirst();
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public String getText() {
        return text;
    }

    public static TotalReturn getTotalReturnResult(Result result, int cost) {
        return new TotalReturn(result.profit(cost));
    }

    public static Optional<Rank> isMatchedSize(int size) {
        return Arrays.stream(Rank.values())
                .filter(m -> m.getRank() == size)
                .findFirst();
    }
}

