package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers(LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        lottoNumbers.addAll(lottoNumberSelectPolicy.selectNumbers());
    }

    public LottoNumbers(final List<Integer> numbers) {
        lottoNumbers.addAll(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }
}
