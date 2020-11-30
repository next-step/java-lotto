package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoAutoMachine implements LottoMachine {

    @Override
    public Lotto createLotto(int capacity) {
        List<Integer> numbers = ProviderLottoNumbers.findAllLottoNumbers();
        Collections.shuffle(numbers);

        return new Lotto(numbers.stream()
                .limit(capacity)
                .collect(Collectors.toCollection(TreeSet::new)));
    }


}
