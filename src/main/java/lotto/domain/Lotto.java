package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int DEFAULT_QUANTITY = 6;
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers =  new LottoNumbers(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
