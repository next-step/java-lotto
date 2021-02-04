package lotto.domain;

import java.util.HashSet;
import java.util.List;

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
            throw new IllegalArgumentException("로또 번호는 6개여야만 합니다.");
        }
    }

    private void validateDuplicateLottoNumbers(final List<LottoNumber> lottoNumbers) {
        boolean allUniqueElements = lottoNumbers.stream()
                .allMatch(new HashSet<>()::add);
        if (!allUniqueElements) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
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