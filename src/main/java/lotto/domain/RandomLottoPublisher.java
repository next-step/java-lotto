package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoPublisher implements LottoPublisher {
    private final List<Integer> allNumbers;

    public RandomLottoPublisher() {
        allNumbers = buildAllLottoNumbers();
    }

    private List<Integer> buildAllLottoNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = Lotto.MIN; i <= Lotto.MAX; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public List<Integer> get() {
        Collections.shuffle(allNumbers);
        List<Integer> result = new ArrayList<>(allNumbers.subList(0, 6));
        Collections.sort(result);
        return result;
    }
}
