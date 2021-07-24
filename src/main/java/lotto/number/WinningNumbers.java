package lotto.number;

import java.util.List;

public class WinningNumbers extends LottoNumbers {

    public WinningNumbers(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static WinningNumbers from(List<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers);
    }

}
