package study.lotto.domain;

import study.lotto.util.LottoNumberGenerator;

import java.util.*;

public class LottoNumbers {
    private List<LottoNumber> markedLottoNumbers;

    public LottoNumbers(List<LottoNumber> markedLottoNumbers) {
        this.markedLottoNumbers = markedLottoNumbers;
    }

    public static LottoNumbers randomNumbers() {
        return new LottoNumbers(LottoNumberGenerator.randomNumbers());
    }

    public List<LottoNumber> lottoNumbers() {
        return markedLottoNumbers;
    }

    public int matchWinningNumberCount(LottoNumbers winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>(winningNumbers.lottoNumbers());
        numbers.removeAll(markedLottoNumbers);
        return LottoGame.MARK_SIZE - numbers.size();
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return markedLottoNumbers.contains(bonusNumber);
    }
}
