package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {

    private LottoNumbers values;

    private WinningLottoNumbers(LottoNumbers values) {
        this.values = values;
    }

    public Rank rank(LottoNumbers numbers) {
        return Rank.calculate(values.matches(numbers));
    }

    public static WinningLottoNumbers of(List<LottoNumber> values) {
        return new WinningLottoNumbers(LottoNumbers.from(values));
    }
}
