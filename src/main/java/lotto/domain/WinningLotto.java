package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private static final String BONUS_NUMBER_IS_NOT_LOTTO_NUMBER =
        "보너스 번호는 6개의 로또 번호와 다른 번호로 사용해야 합니다.";

    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
        validateLottoNumbers();
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(LottoNumbers.of(numbers),
                                LottoNumber.of(bonusNumber));
    }

    private void validateLottoNumbers() {
        if (super.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_LOTTO_NUMBER);
        }
    }

    public WinningType getWinningType(Lotto lotto) {
        return WinningType.find(getMatchCount(lotto), isBonusMatched(lotto));
    }

    private boolean isBonusMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
