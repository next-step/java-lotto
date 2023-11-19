package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> NUMBER_LIST = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private List<Integer> lotto;

    public Lotto() {
        this.lotto = createLotto();
    }

    private List<Integer> createLotto() {
        Collections.shuffle(NUMBER_LIST);
        List<Integer> newLotto = new ArrayList<>(NUMBER_LIST.subList(0, 6));
        Collections.sort(newLotto);
        return newLotto;
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int matchCount(List<Integer> winningNumbers) {
        return lotto.stream().mapToInt(number -> compare(winningNumbers, number)).sum();
    }

    private int compare(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
