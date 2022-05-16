package lotto.model;

import java.util.List;

public class Winning {
    private final int bonusNumber;
    private final Lottery answer;

    public Winning(Lottery answer, int bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public Reward matchWin(List<LotteryNumber> lotteryNumbers) {
        int win = 0;
        for (LotteryNumber lotteryNumber : lotteryNumbers) {
            win += countWin(lotteryNumber);
        }
        Reward bonus = hasBonus(lotteryNumbers);
        if (win == 5 && bonus != null) {
            return bonus;
        }
        return Reward.of(win, false);
    }

    public int countWin(LotteryNumber number) {
        if (this.answer.lotteryNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public Reward hasBonus(List<LotteryNumber> lottery) {
        if (lottery.contains(this.bonusNumber)) {
            return Reward.of(5, true);
        }
        return null;
    }
}
