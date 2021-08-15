package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        lottoNumbers.addAll(LottoNumberSelector.selectNumbers());
    }

    public LottoNumbers(final List<Integer> numbers) {
        lottoNumbers.addAll(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
