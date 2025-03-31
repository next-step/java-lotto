package domain.model;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.getNumbers();
    }
}
