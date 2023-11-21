package step4.model;

import java.util.Arrays;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.lottoNumbers.getNumbers().toArray());
    }
}
