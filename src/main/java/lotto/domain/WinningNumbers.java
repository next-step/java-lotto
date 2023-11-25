package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers extends LottoNumbers {
    private final LottoNumber bonusNumber;

    // 수동 생성(당첨번호)
    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.validateCount(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public long matchNumbers(LottoNumbers targetLottoNumbers) {
        return this.numbers.stream().filter(targetLottoNumbers::isNumberMatched).count();
    }

    public boolean containBonusNumber(LottoNumbers targetLottoNumbers) {
        return targetLottoNumbers.isNumberMatched(this.bonusNumber);
    }

    LottoNumber bonusNumber() {
        return this.bonusNumber;
    }
}
