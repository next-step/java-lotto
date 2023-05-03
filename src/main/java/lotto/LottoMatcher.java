package lotto;


import java.util.Arrays;

public enum LottoMatcher {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    NOTHING(0);

    private final int rank;

    LottoMatcher(int rank) {
        this.rank = rank;
    }

    private boolean is(int rank) {
        return this.rank == rank;
    }

    public static LottoMatcher of(int rank) {
        return Arrays.stream(LottoMatcher.values())
                .filter(lottoResult -> lottoResult.is(rank))
                .findAny()
                .orElse(LottoMatcher.NOTHING);
    }
}
