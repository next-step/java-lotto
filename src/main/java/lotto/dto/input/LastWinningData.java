package lotto.dto.input;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import lotto.util.SplitUtil;

import java.util.TreeSet;

public class LastWinningData {

    private String winningNumberValue;

    public LastWinningData(String winningNumberValue) {
        this.winningNumberValue = winningNumberValue;
    }

    public WinningNumbers toWinningLottoNumbers() {
        String[] winningNumberValues = SplitUtil.split(winningNumberValue);
        TreeSet<LottoNumber> winningNumberTreeSet = new TreeSet<>();
        for (String value : winningNumberValues) {
            winningNumberTreeSet.add(LottoNumber.valueOf(value));
        }
        return new WinningNumbers(winningNumberTreeSet);
    }
}
