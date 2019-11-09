package lotto.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum LottoRank {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private int count;
    private boolean considerBonus;
    private int money;

    LottoRank(int count, boolean considerBonus, int money) {
        this.count = count;
        this.considerBonus = considerBonus;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public boolean isConsiderBonus() {
        return considerBonus;
    }

    public static LottoRank getRank(int count, boolean matchBonus) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.count == count)
                .filter(lottoRank -> filterMatchBonus(count, matchBonus, lottoRank))
                .findFirst()
                .orElse(LottoRank.NONE);
    }

    private static boolean filterMatchBonus(int count, boolean matchBonus, LottoRank lottoRank) {
        if (count != SECOND.count) {
            return true;
        }

        return lottoRank.considerBonus == matchBonus;
    }
}
