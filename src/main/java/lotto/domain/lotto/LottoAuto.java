package lotto.domain.lotto;

import lotto.domain.AutoLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAuto extends Lotto {

    public LottoAuto() {
        super(AutoLottoNumbers.autoNumbers());
    }

    @Override
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>(super.getNumbers());
        Collections.shuffle(numbers);
        return Collections.unmodifiableList(numbers.stream()
                .limit(MARKED_RANGE)
                .sorted()
                .collect(Collectors.toList()));
    }
}
