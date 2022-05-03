package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Set;

public class LottoNumbers {
    private static final int LOTTO_NUMBER = 6;
    private static final int BONUS_BALL_CONDITION = 5;
    private Set<Integer> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        if (isNotLottoSize(lottoNumbers)) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_COUNT, lottoNumbers.toString());
        }
        this.lottoNumbers = lottoNumbers;
    }

    private boolean isNotLottoSize(Set<Integer> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_NUMBER;
    }

    public int match(WinningLotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public boolean checkBonus(WinningLotto winningLotto, int countOfMatch) {
        boolean isBonus = false;
        if (countOfMatch == BONUS_BALL_CONDITION) {
            return lottoNumbers.contains(winningLotto.getBonusBall());
        }
        return isBonus;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
