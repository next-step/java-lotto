package autoLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.IntStream.*;

public class Lotto {

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();

        range(1, 46).forEach(numbers :: add);
        Collections.shuffle(numbers);

        range(0, 6).forEach(i -> lotto.add(numbers.get(i)));
        Collections.sort(lotto);
    }

    public Lotto(Integer[] numbers) {
        this.lotto = Arrays.asList(numbers);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public int getMatchQuantity(List<Integer> numbers) {
        int count = 0;

        for (Integer number : numbers) {
            count = getCount(count, number);
        }

        return count;
    }

    private int getCount(int count, Integer number) {
        if (lotto.contains(number)) {
            count++;
        }
        return count;
    }

}
