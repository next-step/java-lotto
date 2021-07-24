package lotto.number;

import java.util.List;

public class WinningNumbers extends LottoNumbers {

    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);

        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(List<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers, LottoNumber.from(45));
    }

    public static WinningNumbers of(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }
}
