package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoPublisher {
    private final List<Integer> allNumbers;

    public RandomLottoPublisher() {
        allNumbers = allNumbers();
    }

    private List<Integer> allNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            list.add(i);
        }
        return list;
    }

    public List<Integer> randomNumber() {
        Collections.shuffle(allNumbers);
        List<Integer> result = allNumbers.subList(0, 6);
        Collections.sort(result);
        return result;
    }
}
