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

    public Reward findWin(Lottery answer, int bonusNumber) {
        int win = 0;
        for (int number : this.numbers) {
            win += matchNumber(answer, number);
        }
        if (win == 5 && hasBonus(bonusNumber)) {
            return Reward.of(5, true);
        }
        return Reward.of(win, false);
    }

    private int matchNumber(Lottery lottery, int number) {
        if (lottery.numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean hasBonus(int bonusNumber) {
        return this.matchNumber(this, bonusNumber) == 1;
    }
}
