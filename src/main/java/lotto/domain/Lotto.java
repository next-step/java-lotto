package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumbersWrapper numbers;

    Lotto(LottoNumbersWrapper lottoNumbersWrapper) {
        this.numbers = lottoNumbersWrapper;
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public int getMatchCount(LottoNumbersWrapper lottoNumbersWrapper) {
        return numbers.getMatchCount(lottoNumbersWrapper);
    }

    public boolean isMatchToBonusNumber(int bonusNumber) {
        return numbers.isMatchToBonusNumber(bonusNumber);
    }


}
