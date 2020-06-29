package lotto.domain.ticket;

import lotto.domain.store.LottoNumber;
import lotto.domain.winning.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class LottoTicket {
    protected static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    protected LottoTicket(List<LottoNumber> lottoNumbers) {
        final List<LottoNumber> createdLottoNumber = create(lottoNumbers);
        if (!isValid(createdLottoNumber)) {
            throw new RuntimeException();
        }
        Collections.sort(createdLottoNumber);
        this.lottoNumbers = createdLottoNumber;
    }

    private boolean isValid(final List<LottoNumber> lottoNumbers) {
        return isValidSize(lottoNumbers)
                && isValidIndependentNumber(lottoNumbers);
    }

    private boolean isValidSize(final List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == NUMBER_OF_LOTTO_NUMBERS;
    }

    private boolean isValidIndependentNumber(final List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        return set.size() == lottoNumbers.size();
    }

    public Rank getRankBy(final LottoTicket winningLottoTicket, final LottoNumber bonusNumber) {
        final int countOfMatch = (int) lottoNumbers.stream()
                .filter(winningLottoTicket::has)
                .count();
        final boolean isBonusMatch = this.has(bonusNumber);
        return Rank.valueOf(countOfMatch, isBonusMatch);
    }

    public boolean has(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    protected abstract List<LottoNumber> create(final List<LottoNumber> lottoNumbers);
}
