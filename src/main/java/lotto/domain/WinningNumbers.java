package lotto.domain;

import lotto.utils.StringUtils;

import java.util.List;

public class WinningNumbers extends LottoNumbers{

    private final LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(String winningNumbers, String bonusNumber) {
        return of(StringUtils.toIntegerList(winningNumbers), StringUtils.parseInteger(bonusNumber));
    }

    public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(toLottoNumberList(winningNumbers), new LottoNumber(bonusNumber));
    }

    public boolean isSameAsBonusNumber(LottoNumber bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }
}
