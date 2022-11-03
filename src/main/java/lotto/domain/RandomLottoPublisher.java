package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoPublisher implements LottoPublisher {
    private final List<LottoNumber> allNumbers;

    public RandomLottoPublisher() {
        allNumbers = LottoNumber.buildAllLottoNumbers();
    }

    @Override
    public Lotto get() {
        Collections.shuffle(allNumbers);
        List<LottoNumber> result = new ArrayList<>(allNumbers.subList(0, Lotto.COUNT));
        Collections.sort(result);
        return new Lotto(result);
    }
}
