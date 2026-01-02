package lotto;

public class WinningNumbers {
    private final Lotto winning;
    private final BonusNumber bonus;

    public WinningNumbers(Lotto winning, BonusNumber bonus) {
        validateBonusNotDuplicated(winning, bonus);
        this.winning = winning;
        this.bonus = bonus;
    }

    public WinningNumbers(Lotto winning, int bonus) {
        this(winning, BonusNumber.of(bonus));
    }

    public Rank match(Lotto ticket) {
        int matchCount = ticket.matchCount(winning);
        boolean bonusMatched = ticket.contains(bonus.value());
        return Rank.of(matchCount, bonusMatched);
    }

    private void validateBonusNotDuplicated(Lotto winning, BonusNumber bonus) {
        if (winning.contains(bonus.value())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없다.");
        }
    }
}
