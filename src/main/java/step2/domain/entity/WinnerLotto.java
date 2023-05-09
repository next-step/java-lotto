package step2.domain.entity;

import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoPrize;

import java.util.List;

import static step2.domain.entity.Lotto.LOTTO_NUMBER_SIZE;

public class WinnerLotto {

    private final LottoNumber bonusNumber;
    private final List<LottoNumber> winnerLottoNumbers;

    public WinnerLotto(LottoNumber bonusNumber, List<LottoNumber> winnerLottoNumbers) {
        validate(winnerLottoNumbers);
        validateDuplicateNumber(winnerLottoNumbers, bonusNumber);

        this.bonusNumber = bonusNumber;
        this.winnerLottoNumbers = winnerLottoNumbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<LottoNumber> winnerLottoNumbers, LottoNumber bonusNumber) {
        if (winnerLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    "당첨 번호에 보너스 번호가 존재합니다. 당첨 번호: " + winnerLottoNumbers + ", 보너스 번호: " + bonusNumber
            );
        }
    }

    public LottoPrize prize(Lotto lotto) {
        final var sameNumberCount = lotto.compareWinnerLottoNumbers(winnerLottoNumbers);

        if (lotto.isSecondBonusLotto(sameNumberCount, bonusNumber)) {
            return LottoPrize.SECOND_BONUS;
        }

        return LottoPrize.prize(sameNumberCount);
    }
}
