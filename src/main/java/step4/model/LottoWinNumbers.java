package step4.model;

import java.util.List;

public class LottoWinNumbers {

    private static final int MAX_LOTTO_NUMBER = 45;
    private final LottoNumbers lottoNumbers;
    private final int bonusNumber;

    public LottoWinNumbers(LottoNumbers lottoNumbers, int bonusNumber) {
        validate(lottoNumbers.getNumbers().size(), lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    private void validate(int number, LottoNumbers lottoNumbers, int bonusNumber) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자가 아닙니다.");
        }

        if (lottoNumbers.isContain(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 포함된 보너스 번호 입니다.");
        }
    }
}
