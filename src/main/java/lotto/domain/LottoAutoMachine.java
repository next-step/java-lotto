package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoAutoMachine extends LottoMachine {

    @Override
    public LottoNumbers createLottoNumber() {
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.stream()
                                .limit(LOTTO_NUMBER_CAPACITY)
                                .sorted()
                                .collect(Collectors.toCollection(TreeSet::new)));
    }
}
