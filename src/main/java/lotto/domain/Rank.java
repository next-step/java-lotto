package lotto.domain;

public enum Rank {
    FIRST, SECOND, THIRD, FOURTH, FIFTH, NOTHING;

    public static Rank getRank(int score, boolean hasBonus) {
        if (score == 6) { return Rank.FIRST; }
        if (score == 5 && hasBonus) { return Rank.SECOND; }
        if (score == 5) { return Rank.THIRD; }
        if (score == 4) { return Rank.FOURTH; }
        if (score == 3) { return Rank.FIFTH; }
        return Rank.NOTHING;
    }
}
