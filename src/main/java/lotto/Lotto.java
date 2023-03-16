package lotto;

import exception.LottoException;
import java.util.List;


public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        LottoException.validate(numbers);
        this.lottoNumbers = numbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}


