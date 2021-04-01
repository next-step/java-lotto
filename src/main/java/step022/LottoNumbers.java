package step022;

import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers makedNumbers(MakeRandomNumberRule makeRandomNumberRule) {
        for (int numbers : makeRandomNumberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
        return this;
    }
}
