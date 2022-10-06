package lottogame.domain.lotto;

import java.util.List;

public class LottoResult {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoResult(List<Integer> numbers, int bonusNumber) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
