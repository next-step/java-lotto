package lotto.model;

import java.util.Optional;
import java.util.TreeSet;

public class Winning {
    private final int bonusNumber;
    private final Lottery answer;

    public Winning(Lottery answer, int bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public Reward matchWin(TreeSet<LotteryNumber> lotteryNumbers) {
        int win = 0;
        for (LotteryNumber lotteryNumber : lotteryNumbers) {
            win += countWin(lotteryNumber);
        }
        Optional<Reward> bonus = bonus(lotteryNumbers);
        if (win == 5 && bonus.isPresent() ) {
            return bonus.get();
        }
        return Reward.of(win, false);
    }

    private int countWin(LotteryNumber number) {
        if (this.answer.lotteryNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public Optional<Reward> bonus(TreeSet<LotteryNumber> lottery) {
        if (lottery.contains(new LotteryNumber(this.bonusNumber))) {
            return Optional.ofNullable(Reward.of(5, true));
        }
        return null;
    }
}
