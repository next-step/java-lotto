package lotto.model;

import java.util.TreeSet;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;

    public WinningLotto(LottoNumbers winningNumbers) {
        this.winningLottoNumbers = winningNumbers;
    }

    public int correctCount(LottoNumbers lottoNumbers) {
        TreeSet<LottoNumber> numbers = lottoNumbers.lottoNumbers();
        numbers.removeAll(winningLottoNumbers.lottoNumbers());
        return LOTTO_NUMBER_COUNT - numbers.size();
    }
}
