package step2.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND_BONUS(5, 30_000_000, true),
    SECOND(5, 1_500_000, false),
    THIRD(4, 50_000, false),
    FOURTH(3, 5_000, false),
    SIDE(0, 0, false);

    private int count;
    private int money;
    private boolean bonus;

    LottoRank(int count, int money, boolean bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
    }

    public static LottoRank of(long matchCount, boolean matchBonus) {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank.count == matchCount)
                .filter(lottoRank -> !lottoRank.bonus || matchBonus)
                .findFirst()
                .orElse(LottoRank.SIDE);
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static List<LottoRank> getLottoMatchingList() {
        return Stream.of(LottoRank.values())
                .sorted(Comparator.comparingInt(rank -> rank.money))
                .collect(Collectors.toList());
    }
}
