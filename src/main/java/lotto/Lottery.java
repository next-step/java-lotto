package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    public final List<Integer> box;
    public final List<Integer> numbers;

    public Lottery(List<Integer> lotteryBoxNumbers) {
        shuffleBox(lotteryBoxNumbers);
        this.box = lotteryBoxNumbers;
        this.numbers = findSixNumbers();
    }

    public void shuffleBox(List<Integer> lotteryBoxNumbers) {
        Collections.shuffle(lotteryBoxNumbers);
    }

    public List<Integer> findSixNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(box.get(i));
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
