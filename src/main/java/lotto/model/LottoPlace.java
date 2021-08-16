package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoPlace {
    FIRST(6, 2_000_000_000, BonusState.NO_MATTER),
    SECOND(5, 30_000_000, BonusState.HIT),
    THIRD(5, 1_500_000, BonusState.MISS),
    FOURTH(4, 50_000, BonusState.NO_MATTER),
    FIFTH(3, 5_000, BonusState.NO_MATTER),
    LOSE(Arrays.asList(2, 1, 0), 0, BonusState.NO_MATTER);

    private final List<Integer> correctCounts;
    private final BonusState bonusState;
    private final Money winningPrice;

    LottoPlace(List<Integer> correctCounts, int winningPrice, BonusState bonusState) {
        this.correctCounts = correctCounts;
        this.winningPrice = new Money(winningPrice);
        this.bonusState = bonusState;
    }

    LottoPlace(int winningCount, int winningPrice, BonusState bonusState) {
        this(Arrays.asList(winningCount), winningPrice, bonusState);
    }

    public Money getWinningPrice() {
        return winningPrice;
    }

    public Integer getFirstCorrectCount() {
        return correctCounts.get(0);
    }

    public BonusState getBonusState() {
        return bonusState;
    }

    public static LottoPlace decidePlace(int correctCount, boolean correctBonus) {
        return Arrays.stream(LottoPlace.values())
            .filter(lottoPlace -> lottoPlace.correctCounts.contains(correctCount))
            .filter(lottoPlace -> lottoPlace.bonusState.match(correctBonus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(correctCount + " 는 잘못된 correctCount 입니다!"));
    }
}
