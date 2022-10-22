package autoLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.IntStream.*;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 46;
    private static final int ZERO = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;


    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();

        range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX).forEach(numbers :: add);
        Collections.shuffle(numbers);

        range(ZERO, LOTTO_NUMBER_SIZE).forEach(i -> lotto.add(numbers.get(i)));
        Collections.sort(lotto);
    }

    public Lotto(Integer[] numbers) {
        this.lotto = Arrays.asList(numbers);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public int countOfMatch(List<Integer> numbers) {
        int count = 0;

        for (Integer number : numbers) {
            count = getCount(count, number);
        }

        return count;
    }

    public boolean matchBonus(int number) {
        return lotto.contains(number);
    }

    private int getCount(int count, Integer number) {
        if (lotto.contains(number)) {
            count++;
        }
        return count;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
