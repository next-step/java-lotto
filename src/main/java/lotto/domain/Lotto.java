package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {

        this.numbers = createLottoNumbers();
        this.numbers.sort(Integer::compareTo);
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottos = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            lottos.add(i);
        }

        Collections.shuffle(lottos);

        return lottos.subList(0, 6);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
