package lotto;


import java.util.Arrays;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addFirst();
        }
    },
    SECOND_MATCH(5, 1_500_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addSecond();
        }
    },
    THIRD_MATCH(4, 50_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addThird();
        }
    },
    FOURTH_MATCH(3, 5_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addFourth();
        }
    },
    NONE_MATCH(0, 0) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            // do nothing
        }
    };

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

    public abstract void incrementScore(LottoScore lottoScore);
}
