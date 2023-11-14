package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<LottoNumber> lottoNumbers;

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static WinningNumbers of(Lotto lotto, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.lottoNumbers());
        lottoNumbers.add(bonusNumber);
        return new WinningNumbers(lottoNumbers);
    }
}
