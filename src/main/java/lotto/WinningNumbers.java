package lotto;


import lotto.MatchResult;

public class WinningNumbers {
    private final Lotto winning;
    private final LottoNumber bonus;

    public WinningNumbers(Lotto winning, int bonus) {
        this(winning, LottoNumber.from(bonus));
    }

    public WinningNumbers(Lotto winning, LottoNumber bonus) {
        validateBonusNotDuplicated(winning, bonus);
        this.winning = winning;
        this.bonus = bonus;
    }

    private void validateBonusNotDuplicated(Lotto winning, LottoNumber bonus) {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다. bonus=" + bonus.value());
        }
    }

    public Rank match(Lotto ticket) {
        int matchCount = ticket.matchCount(winning);
        boolean bonusMatched = ticket.contains(bonus);
        return Rank.of(new MatchResult(matchCount, bonusMatched));
    }

    public WinningStatistics match(Lottos tickets) {
        WinningStatistics stats = new WinningStatistics();
        for (Lotto ticket : tickets.values()) {
            stats.accumulate(match(ticket));
        }
        return stats;
    }
}
