package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.lottoNumbers = new LottoNumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);

        if (lottoNumbers.isContainNumber(this.bonusNumber)) {
            throw new IllegalArgumentException("[추첨 로또] 보너스 숫자가 중복됩니다.");
        }
    }

    public LottoNumbers getLottoNumbers() {
        return new LottoNumbers(lottoNumbers);
    }

    public LottoNumber getBonusNumber() {
        return new LottoNumber(bonusNumber.getNumber());
    }
}
