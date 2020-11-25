package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAutoMachine implements LottoMachine {

    @Override
    public Lotto createLotto() {
        List<Integer> numbers = LottoNumbers.getLottoNumbers();
        Collections.shuffle(numbers);

        return new Lotto(numbers.stream().collect(Collectors.toSet()));
    }
}
