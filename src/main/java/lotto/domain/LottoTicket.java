package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class LottoTicket {
    protected static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    protected static final int START_LOTTO_NUMBER = 1;
    protected static final int END_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    protected LottoTicket(List<Integer> lottoNumbers) {
        final List<Integer> createdLottoNumber = createLottoNumber(lottoNumbers);
        if (!isValid(createdLottoNumber)) {
            throw new RuntimeException();
        }
        Collections.sort(createdLottoNumber);
        this.lottoNumbers = createdLottoNumber;
    }

    private boolean isValid(final List<Integer> lottoNumbers) {
        return isValidSize(lottoNumbers)
                && isValidNumberRange(lottoNumbers)
                && isValidIndependentNumber(lottoNumbers);
    }

    private boolean isValidSize(final List<Integer> lottoNumbers) {
        return lottoNumbers.size() == NUMBER_OF_LOTTO_NUMBERS;
    }

    private boolean isValidNumberRange(final List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .allMatch(lottoNumber -> lottoNumber >= START_LOTTO_NUMBER && lottoNumber <= END_LOTTO_NUMBER);
    }

    private boolean isValidIndependentNumber(final List<Integer> lottoNumbers) {
        final Set<Integer> set = new HashSet<>(lottoNumbers);
        return set.size() == lottoNumbers.size();
    }

    public Rank getRankBy(final LottoTicket winningLottoTicket, final int bonusNumber) {
        int countOfMatch = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningLottoTicket.hasNumber(lottoNumber)) {
                countOfMatch++;
            }
        }

        boolean isBonusMatch = false;

        if (countOfMatch == 5) {
            if (this.hasNumber(bonusNumber)) {
                isBonusMatch = true;
            }
        }
        return Rank.valueOf(countOfMatch, isBonusMatch);
    }

    public boolean hasNumber(final int lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    protected abstract List<Integer> createLottoNumber(final List<Integer> lottoNumbers);
}
