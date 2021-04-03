package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumberService implements LottoNumberService {
    public static final int CREATION_MAX_COUNT = 6;

    @Override
    public Numbers creation() {
        List<Integer> numbers = new ArrayList<>(Number.lottoNumber.keySet());

        Collections.shuffle(numbers);
        numbers = reduce(numbers);
        Collections.sort(numbers);

        return new Numbers(numbers);
    }

    private List<Integer> reduce(List<Integer> numbers) {
        List<Integer> reduce = new ArrayList<>();
        for (int i = 0; i < CREATION_MAX_COUNT; i++) {
            reduce.add(numbers.get(i));
        }
        return reduce;
    }
}
