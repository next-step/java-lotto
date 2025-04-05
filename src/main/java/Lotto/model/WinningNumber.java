package Lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("bonusNumber is already included in winningNumbers.");
        }
        this.numbers = Lotto.toLottoNumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int countMatchedNumber(Lotto lotto) {
        int matchedCount = 0;
        for (LottoNumber lottoNumber : lotto.numbers()) {
            if (this.numbers.contains(lottoNumber)) {
                matchedCount++;
            }
        }

        return matchedCount;
    }

    public boolean matchedBonusNumber(Lotto lotto) {
        return lotto.numbers().contains(this.bonusNumber) ? true : false;
    }

}
