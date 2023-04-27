package lotto.data;

import java.util.Collections;
import java.util.List;

import static lotto.service.LottoGame.makeLottoNumberPool;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        this.numbers = makeNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> makeNumbers() {
        final int FROM_INDEX = 0;
        final int TO_INDEX = 6;

        final List<Integer> lotteNumbers = makeLottoNumberPool();
        Collections.shuffle(lotteNumbers);

        return lotteNumbers.subList(FROM_INDEX, TO_INDEX);
    }
}
