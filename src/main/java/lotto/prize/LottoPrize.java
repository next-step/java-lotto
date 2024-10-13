package lotto.prize;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000, "로또 번호 6개를 다 맞은 경우"),
    SECOND(5, true, 30_000_000, "로또 번호 5개와 보너스 번호를 맞은 경우"),
    THIRD(5, false, 1_500_000, "로또 번호 5개를 맞은 경우"),
    FOURTH(4, false, 50_000, "로또 번호 4개를 맞은 경우"),
    FIFTH(3, false, 5_000, "로또 번호 3개를 맞은 경우"),
    MISS(0, false, 0, "로또에 당첨 되지 않은 경우");

    private static final int MATCH_FIVE_NUMBERS = 5;
    private final int matchedLottoNumbers;
    private final boolean isBonusNeed;
    private final int prizeAmount;
    private final String description;

    LottoPrize(int matchedLottoNumbers, boolean isBonusNeed, int prizeAmount, String description) {
        this.matchedLottoNumbers = matchedLottoNumbers;
        this.isBonusNeed = isBonusNeed;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public static LottoPrize getPrize(int matchedLottoNumbers, boolean matchBonus) {
        if (matchedLottoNumbers == MATCH_FIVE_NUMBERS) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(p -> p.matchedLottoNumbers == matchedLottoNumbers)
                .findFirst()
                .orElse(MISS);
    }

    public boolean isWinningPrize(int minWinningMatchCount) {
        return this.matchedLottoNumbers >= minWinningMatchCount;
    }

    public int getMatchedLottoNumbers() {
        return matchedLottoNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusNeed() {
        return isBonusNeed;
    }
}