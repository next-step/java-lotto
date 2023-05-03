package lotto;


import java.util.Arrays;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000),
    SECOND_MATCH(5, 1_500_000),
    THIRD_MATCH(4, 50_000),
    FOURTH_MATCH(3, 5_000),
    NONE_MATCH(0, 0);

    private final int rank;
    private int price;

    LottoMatcher(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    private boolean is(int rank) {
        return this.rank == rank;
    }

    public static LottoMatcher of(int rank) {
        return Arrays.stream(LottoMatcher.values())
                .filter(lottoResult -> lottoResult.is(rank))
                .findAny()
                .orElse(LottoMatcher.NONE_MATCH);
    }

    public int price() {
        return price;
    }
}
