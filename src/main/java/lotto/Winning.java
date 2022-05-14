package lotto;

import java.util.List;

public class Winning {
    private final int bonusNumber;
    private final Lottery answer;

    public Winning(Lottery answer, int bonusNumber) {
        this.answer = answer;
        this.bonusNumber = bonusNumber;
    }

    public int doesMatchAnswer(LotteryNumber number) {
        if (this.answer.lotteryNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public int doesMatchBonus(List<LotteryNumber> numbers) {
        if (numbers.contains(this.bonusNumber)) {
            return 1;
        }
        return 0;
    }

}
