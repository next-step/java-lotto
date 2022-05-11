package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Lottery {
    public final LotteryBox lotteryBox;
    public final List<Integer> numbers;

    public Lottery() {
        this.lotteryBox = new LotteryBox();
        lotteryBox.shuffleBox();
        this.numbers = findSixNumbers();
    }

    public Lottery(List<Integer> numbers) {
        this.lotteryBox = new LotteryBox();
        lotteryBox.shuffleBox();
        this.numbers = numbers;
    }


    public List<Integer> findSixNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(lotteryBox.numbers.get(i));
        }
        return sort(list);
    }

    public List<Integer> sort(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numbers=" + numbers +
                '}';
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
