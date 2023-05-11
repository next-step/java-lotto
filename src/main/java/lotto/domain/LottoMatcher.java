package lotto.domain;


import java.util.Arrays;
import java.util.Map;

public enum LottoMatcher {
    FIRST_MATCH(6, 2_000_000_000, "first"),
    SECOND_MATCH(5, 30_000_000, "second"),
    THIRD_MATCH(5, 1_500_000, "third"),
    FOURTH_MATCH(4, 50_000, "fourth"),
    FIFTH_MATCH(3, 5_000, "fifth"),
    NONE_MATCH(0, 0, "nothing");

    private final int matchOfCount;
    private final int price;
    private final String mapKey;

    LottoMatcher(int matchOfCount, int price, String mapKey) {
        this.matchOfCount = matchOfCount;
        this.price = price;
        this.mapKey = mapKey;
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

    public void incrementScore(Map<String, Integer> map) {
        map.putIfAbsent(mapKey, 0);
        map.computeIfPresent(mapKey, (k, v) -> v + 1);
    }

    public int amount(int count) {
        return price * count;
    }

    public String key() {
        return mapKey;
    }

    public boolean isMatching(){
        return matchOfCount >= 3;
    }
}
