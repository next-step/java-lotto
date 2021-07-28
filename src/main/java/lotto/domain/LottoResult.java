package lotto.domain;

public class LottoResult {

    private final int count;
    private final boolean matchBonus;

    private LottoResult(int count, boolean matchBonus) {
        this.count = count;
        this.matchBonus = matchBonus;
    }

    public static LottoResult of(int count, boolean matchBonus) {
        return new LottoResult(count, matchBonus);
    }

    public int getCount() {
        return count;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
