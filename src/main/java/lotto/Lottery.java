package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Lottery {
    public final List<Integer> boxNumbers = LotteryBox.numbers;
    public final List<Integer> numbers;

    public Lottery() {
        shuffleBox(boxNumbers);
        this.numbers = findSixNumbers();
    }

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void shuffleBox(List<Integer> lotteryBoxNumbers) {
        Collections.shuffle(lotteryBoxNumbers);
    }

    public List<Integer> findSixNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(boxNumbers.get(i));
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
}
