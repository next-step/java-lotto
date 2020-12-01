package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoAutoMachine implements LottoMachine {

    @Override
    public Lotto createLotto(int capacity) {
        List<Integer> numbers = LottoNumber.findAllLottoNumbers();
        Collections.shuffle(numbers);

        return Lotto.of(numbers.stream()
                    .limit(capacity)
                    .collect(Collectors.toCollection(HashSet::new)));
    }


}
