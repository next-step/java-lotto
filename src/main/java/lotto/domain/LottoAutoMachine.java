package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoAutoMachine implements LottoMachine {

    @Override
    public Lotto createLotto(int capacity) {
        List<Integer> numbers = LottoNumbers.findAllLottoNumbers();
        Collections.shuffle(numbers);

        return new Lotto(createLottoNumber(numbers, capacity));
    }

    private LottoNumber createLottoNumber(List<Integer> numbers, int capacity) {
        return LottoNumber.from(numbers.stream()
                        .limit(capacity)
                        .collect(Collectors.toCollection(TreeSet::new)));
    }
}
