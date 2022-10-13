package autoLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
}
