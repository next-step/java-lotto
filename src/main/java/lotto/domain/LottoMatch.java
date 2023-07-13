package lotto.domain;

import java.util.Arrays;

public enum LottoMatch {
    THREE_MATCH(3, 5_000, false),
    FOUR_MATCH(4, 50_000, false),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_BONUS_MATCH(5, 30_000_000, true),
    SIX_MATCH(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean isBonus;

    LottoMatch(int matchCount, int prize, boolean isBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public static LottoMatch find(final int matchCount, final boolean isBonus) {
        return Arrays.stream(values())
                .filter(lottoMatch -> lottoMatch.matchCount == matchCount && lottoMatch.isBonus == isBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상금 타입입니다"));
    }

    public static boolean contains(final int matchCount, final boolean isBonus) {
        return Arrays.stream(values())
                .anyMatch(lottoMatch -> lottoMatch.matchCount == matchCount && lottoMatch.isBonus == isBonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
