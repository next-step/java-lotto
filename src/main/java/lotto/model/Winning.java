package lotto.model;

import java.util.Optional;

public class Winning {
    private final int bonusNumber;
    private final Lottery answer;

    public Winning(Lottery answer, int bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public Reward matchWin(Lottery lottery) {
        Optional<Reward> bonus = lottery.bonus(this.bonusNumber);
        int match = lottery.countMatches(this.answer);
        if (match == 5 && bonus.isPresent() ) {
            return bonus.get();
        }
        return Reward.of(match, false);
    }
}
