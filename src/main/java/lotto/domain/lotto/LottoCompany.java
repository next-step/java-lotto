package lotto.domain.lotto;

import lotto.domain.lotto.util.LottoUtil;
import lotto.domain.result.WinNumber;

public class LottoCompany {

    public static WinNumber announce(String stringNumbers, String bonusWinNumber) {
        return new WinNumber(LottoUtil.stringsToLotto(stringNumbers), LottoNumber.of(bonusWinNumber));
    }

}
