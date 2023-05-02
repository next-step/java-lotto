package lotto;


import java.util.Arrays;

public enum LottoResult {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    NOTHING(0);

    private final int rank;

    LottoResult(int rank) {
        this.rank = rank;
    }

    private boolean is(int rank) {
        return this.rank == rank;
    }

    public static LottoResult of(int rank) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.is(rank))
                .findAny()
                .orElse(LottoResult.NOTHING);
    }
}
