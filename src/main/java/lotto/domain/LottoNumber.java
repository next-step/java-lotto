package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoNumber {

    private final LottoNumbers numbers;

    public LottoNumber(Integer... numbers) {
        this(Arrays.stream(numbers).map(NumberElement::new).toList());
    }

    public LottoNumber(List<NumberElement> numbers) {
        this(new LottoNumbers(numbers));
    }

    public LottoNumber(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public LottoResult checkLottoNumber(List<LottoNumber> useLottoNumber) {
        LottoResult lottoResult = new LottoResult();

        for (LottoNumber lottoNumber : useLottoNumber) {
            lottoResult.putLottoResult(this.numbers.match(lottoNumber));
        }

        return lottoResult;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
