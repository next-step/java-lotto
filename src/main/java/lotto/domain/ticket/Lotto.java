package lotto.domain.ticket;

import lotto.enums.LottoRank;
import lotto.util.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final LottoNumbers lottoNumbers;
    private final int bonusNumber;

    public Lotto(List<Integer> lottoNumbers, int bonusNumber) {
        checkLottoNumbers(lottoNumbers, bonusNumber);

        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void checkLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        if (!LottoNumberValidator.isLottoNumbersSizeCorrect(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto numbers size must be " + LOTTO_NUMBERS_SIZE);
        }

        List<Integer> lottoAndBonusNumbers = new ArrayList<>(lottoNumbers);
        lottoAndBonusNumbers.add(bonusNumber);

        if (!LottoNumberValidator.isLottoNumbersUnique(lottoAndBonusNumbers)) {
            throw new IllegalArgumentException("Every lotto numbers must be unique");
        }

        if (!LottoNumberValidator.isLottoNumbersCorrect(lottoAndBonusNumbers)) {
            throw new IllegalArgumentException("Lotto number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getMatchCounts(Lotto target) {
        int matchCounts = this.lottoNumbers.getNumberOfDuplicatedNumbers(target.lottoNumbers);

        if ((LottoRank.THIRD.getMatchCount() == matchCounts) && (isBonusNumberSame(target))) {
            return LottoRank.SECOND.getMatchCount();
        }

        return matchCounts;
    }

    boolean isBonusNumberSame(Lotto target) {
        return this.bonusNumber == target.bonusNumber;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.getNumbers().toString() + " / " + this.bonusNumber;
    }
}