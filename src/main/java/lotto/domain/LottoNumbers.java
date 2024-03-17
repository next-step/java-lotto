package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }
    public static LottoNumbers from(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public int size() {
        return numbers.size();
    }

    public LottoResult computeLottoResult(LottoNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoNumber lottoNumber : numbers) {
            int containsCount = lottoNumber.containsCount(winningNumber);
            lottoResult.addResultCount(containsCount);
        }
        return lottoResult;
    }
}
