package step4.domain;

import java.util.List;

public class WinningLottoNumbers {
    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.lottoNumbers = Lotto.of(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public int matchedCount(Lotto lotto) {
        return (int) lotto
                .getLottoNumbers()
                .stream()
                .filter(lottoNumber -> lottoNumbers.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }

}
