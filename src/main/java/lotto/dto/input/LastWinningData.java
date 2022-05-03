package lotto.dto.input;

import lotto.domain.LottoNumbers;
import lotto.util.SplitUtil;

public class LastWinningData {

    private String winningNumberValue;

    public LastWinningData(String winningNumberValue) {
        this.winningNumberValue = winningNumberValue;
    }

    public String winningNumberValue() {
        return winningNumberValue;
    }

    public LottoNumbers toWinningLottoNumbers() {
        String[] winningNumbers = SplitUtil.split(winningNumberValue);
        return LottoNumbers.winningLottoNumbers(winningNumbers);
    }
}
