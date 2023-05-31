package lotto.domain;


import java.util.Arrays;
import java.util.Map;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000),
    SECOND_MATCH(5, 30_000_000),
    THIRD_MATCH(5, 1_500_000),
    FOURTH_MATCH(4, 50_000),
    FIFTH_MATCH(3, 5_000),
    NONE_MATCH(0, 0);

    private final int matchOfCount;
    private final int price;

    LottoMatcher(int matchOfCount, int price) {
        this.matchOfCount = matchOfCount;
        this.price = price;
    }

    private boolean is(int matchOfCount) {
        return this.matchOfCount == matchOfCount;
    }

    public static LottoMatcher of(int matchOfCount, boolean matchBonus) {
        if (matchOfCount == 5) {
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

    public void incrementScore(Map<LottoMatcher, Integer> map) {
        map.computeIfPresent(this, (k, v) -> v + 1);
    }

    public int amount(int count) {
        return price * count;
    }


    public boolean isMatching() {
        return matchOfCount >= 3;
    }
}
