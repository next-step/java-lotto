package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.view.ExceptionMessages.LOTTO_NUMBERS_MUST_BE_6_TOTAL;
import static lotto.view.ExceptionMessages.THERE_ARE_DUPLICATE_NUMBERS;

public class LottoTicket {
    private static final int REQUIRED_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_MUST_BE_6_TOTAL);
        }
    }

    private void validateDuplicateLottoNumbers(final List<LottoNumber> lottoNumbers) {
        boolean allUniqueElements = lottoNumbers.stream()
                .allMatch(new HashSet<>()::add);
        if (!allUniqueElements) {
            throw new IllegalArgumentException(THERE_ARE_DUPLICATE_NUMBERS);
        }
    }

    public boolean contains(final LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    public int getSameNumbersCount(final LottoTicket otherLottoTicket) {
        return (int) otherLottoTicket.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}