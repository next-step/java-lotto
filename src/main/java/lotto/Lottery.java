package lotto;

import java.util.List;

public class Lottery {
    public final List<Integer> numbers;

    public Lottery() {
        this.numbers = createLottery();
    }

    private List<Integer> createLottery() {
        return LotteryBox.findSixNumbers();
    }

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Lottery{" + "numbers=" + numbers + '}';
    }

    public Reward findWin(Winning winning) {
        int win = 0;
        for (int number : this.numbers) {
            win += winning.doesMatchAnswer(number);
        }
        if (win == 5 && hasBonus(winning)) {
            return Reward.of(5, true);
        }
        return Reward.of(win, false);
    }

    public boolean hasBonus(Winning winning) {
        return winning.doesMatchBonus(this.numbers) == 1;
    }
}


