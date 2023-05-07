package lotto;


import java.util.Arrays;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addFirst();
        }
    },
    SECOND_MATCH(5, 30_000_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addSecond();
        }
    },
    THIRD_MATCH(5, 1_500_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addThird();
        }
    },
    FOURTH_MATCH(4, 50_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addFourth();
        }
    },
    FIFTH_MATCH(3, 5_000) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            lottoScore.addFifth();
        }
    },
    NONE_MATCH(0, 0) {
        @Override
        public void incrementScore(LottoScore lottoScore) {
            // do nothing
        }
    };

    private final int matchOfCount;
    private int price;

    LottoMatcher(int matchOfCount, int price) {
        this.matchOfCount = matchOfCount;
        this.price = price;
    }

    private boolean is(int matchOfCount) {
        return this.matchOfCount == matchOfCount;
    }

    public static LottoMatcher of(int matchOfCount, boolean matchBonus) {
        if(matchOfCount == 5) {
            return matchBonus ? LottoMatcher.SECOND_MATCH : LottoMatcher.THIRD_MATCH;
        }

        return Arrays.stream(LottoMatcher.values())
                .filter(lottoResult -> lottoResult.is(matchOfCount))
                .findAny()
                .orElse(LottoMatcher.NONE_MATCH);
    }

    public int price() {
        return price;
    }

    public abstract void incrementScore(LottoScore lottoScore);

    public int amount(int count) {
        return price * count;
    }
}
