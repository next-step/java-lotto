package lotto;

import java.util.List;

public class Lottery {
    public final LotteryBox lotteryBox;
    public final List<Integer> numbers;

    public Lottery() {
        this.lotteryBox = new LotteryBox();
        lotteryBox.shuffleBox();
        this.numbers = LotteryBox.findSixNumbers();
    }

    public Lottery(List<Integer> numbers) {
        this.lotteryBox = new LotteryBox();
        lotteryBox.shuffleBox();
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Lottery{" + "numbers=" + numbers + '}';
    }

    public int findWin(Lottery answer) {
        int win = 0;
        for (int number : this.numbers) {
            win += matchNumber(answer, number);
        }
        return win;
    }

    private int matchNumber(Lottery answer, int number) {
        if (answer.numbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
