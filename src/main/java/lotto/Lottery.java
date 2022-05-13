package lotto;

import java.util.List;

public class Lottery {
    //    public final LotteryBox lotteryBox;
    public final List<Integer> numbers;

    public Lottery() {
//        this.lotteryBox = new LotteryBox();
//        LotteryBox.shuffleBox();
        this.numbers = LotteryBox.findSixNumbers();
    }

    public Lottery(List<Integer> numbers) {
//        this.lotteryBox = new LotteryBox();
//        LotteryBox.shuffleBox();
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

//    public int matchAnswer(Winning winning) {
//        return winning.doesMatchAnswer(this.numbers);
//    }

    public boolean hasBonus(Winning winning) {
        return winning.doesMatchBonus(this.numbers) == 1;
    }
}


