package Lotto.constants;

import static Lotto.domain.Lottos.LOTTO_PICK_COUNT;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int countOfMatch;
    private final boolean matchBonus;
    private final int winningMoney;

    Rank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank fromMatchCountAndBonus(int countOfMatch, boolean matchBonus) {
        if (countOfMatch > LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("일치하는 번호는 최대 6개까지만 가능합니다.");
        }
        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return MISS;
    }

    public static Rank fromRankName(String rankName) {
        try {
            return Rank.valueOf(rankName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 Rank 이름입니다: " + rankName, e);
        }
    }

    @Override
    public String toString() {
        return countOfMatch + "개 일치" +
                (matchBonus ? ", 보너스 볼 일치" : "") +
                " (" + winningMoney + "원)";
    }
}
