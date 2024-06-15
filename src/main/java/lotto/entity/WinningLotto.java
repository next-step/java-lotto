package lotto.entity;

public class WinningLotto {
    public static final String WINNING_NUMBERS_AND_BONUS_BALLS_CANNOT_OVERLAP = "당첨번호와 보너스볼은 중복될 수 없습니다.";

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_AND_BONUS_BALLS_CANNOT_OVERLAP);
        }

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
