package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    public final List<LotteryNumber> lotteryNumbers;

    public Lottery() {
        this.lotteryNumbers = createLottery();
    }

    public Lottery(List<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static List<LotteryNumber> toLotteryNumbers(List<Integer> numbers) {
        return numbers.stream().map(number -> new LotteryNumber(number)).collect(Collectors.toList());
    }

    private List<LotteryNumber> createLottery() {
        return LotteryBox.findSixNumbers();
    }

    @Override
    public String toString() {
        return lotteryNumbers + "";
    }

    public Reward findWin(Winning winning) {
        int win = 0;
        for (LotteryNumber lotteryNumber : this.lotteryNumbers) {
            win += winning.doesMatchAnswer(lotteryNumber);
        }
        if (win == 5 && hasBonus(winning) != null) {
            return hasBonus(winning);
        }
        return Reward.of(win, false);
    }

    public Reward hasBonus(Winning winning) {
        return winning.doesMatchBonus(this.lotteryNumbers);
    }
}


