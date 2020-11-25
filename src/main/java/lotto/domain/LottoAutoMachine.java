package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoAutoMachine implements LottoMachine {

    private static final int CAPACITY = 6;

    @Override
    public Lotto createLotto() {
        List<Integer> numbers = LottoNumbers.getLottoNumbers();
        Collections.shuffle(numbers);

        return new Lotto(numbers.stream()
                    .limit(CAPACITY)
                    .collect(Collectors.toCollection(TreeSet::new)));
    }
}
