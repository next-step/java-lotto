package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    MISS(0,  List.of(BonusMatching.TRUE, BonusMatching.FALSE), 0),
    FIFTH(3,  List.of(BonusMatching.TRUE, BonusMatching.FALSE), 5_000),
    FOURTH(4,  List.of(BonusMatching.TRUE, BonusMatching.FALSE), 50_000),
    THIRD(5,  List.of(BonusMatching.FALSE), 1_500_000),
    SECOND(5,  List.of(BonusMatching.TRUE), 30_000_000),
    FIRST(6, List.of(BonusMatching.FALSE), 2_000_000_000),
    ;

    private final int countOfMatch;
    private final List<BonusMatching> hasMatchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, List<BonusMatching> hasMatchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.hasMatchBonus = hasMatchBonus;
        this.winningMoney = winningMoney;
    }

    public boolean hasMatchBonus(boolean bonus) {
        return this.hasMatchBonus.contains(BonusMatching.from(bonus));
    }

    public int calculateRankByCount(int count) {
        return winningMoney * count;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch && rank.hasMatchBonus(matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}
