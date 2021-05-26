package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningLottoNumbers = winningNumbers;
    }

    public int correctCount(TreeSet<LottoNumber> winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>(winningNumbers);
        numbers.removeAll(winningLottoNumbers.lottoNumbers());
        return LOTTO_NUMBER_COUNT - numbers.size();
    }
}
