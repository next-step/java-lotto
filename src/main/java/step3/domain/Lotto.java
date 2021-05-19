package step3.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new LottoNumbers(numbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
