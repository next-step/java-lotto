package lotto.model;

import org.jetbrains.annotations.NotNull;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        Optional<Reward> bonus = bonus(lotteryNumbers);
        if (win == 5 && bonus.isPresent() ) {
            return bonus.get();
        }
        return Reward.of(win, false);
    }

    public int countWin(LotteryNumber number) {
        if (this.answer.lotteryNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public Optional<Reward> bonus(List<LotteryNumber> lottery) {
        if (lottery.contains(new LotteryNumber(this.bonusNumber))) {
            return Optional.ofNullable(Reward.of(5, true));
        }
        return null;
    }
}
