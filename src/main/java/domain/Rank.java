package domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

public enum Rank {
    First(6, false, 2_000_000_000),
    Second(5, true, 3_000_000),
    Third(5, false, 1_500_000),
    Fourth(4, false, 50_000),
    Fifth(3, false, 5000),
    None(-1, false, 0);

    private int matchCount;
    private boolean matchBonus;

    private long prizeMoney;

    Rank(int matchCount, boolean matchBonus, long prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
    }

    public static Rank calculate(int matchCount, boolean matchBonus) {
        Optional<Rank> rank = Arrays.stream(Rank.values())
            .filter(r -> r.matchCount == matchCount)
            .filter(r -> r.matchBonus == matchBonus)
            .findFirst();

        return rank.orElse(None);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeMoneyForDisplay() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.KOREA);
        return currency.format(prizeMoney);
    }
}
