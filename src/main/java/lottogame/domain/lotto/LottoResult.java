package lottogame.domain.lotto;

import java.util.List;

public class LottoResult {
    private final LottoNumbers lottoNumbers;
    private final BonusLottoNumber bonusNumber;

    public LottoResult(List<Integer> numbers, int bonusNumber) {
        this.lottoNumbers = LottoNumbers.valueOf(numbers);
        this.bonusNumber = new BonusLottoNumber(bonusNumber, lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public BonusLottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
