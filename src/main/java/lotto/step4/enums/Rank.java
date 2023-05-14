package lotto.step4.enums;

import lotto.step4.domain.Result;
import lotto.step4.domain.TotalReturn;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 200_000_000, "6개 일치 (2,000,000,000원)- "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치(30,000,000원)- "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)- "),
    FOURTH(4, 50_000, "4개 일치 (50,000원)- "),
    FIFTH(3, 5_000, "3개 일치 (5,000원)- "),
    MISS(0, 0, "낙첨(0원)- ");

    private final int rank;
    private final int prize;
    private final String text;

    Rank(int rank, int prize, String text) {
        this.rank = rank;
        this.prize = prize;
        this.text = text;
    }

    public static Rank of(int rank, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(r -> r.rank == rank)
                .filter(r -> !r.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(MISS);
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

