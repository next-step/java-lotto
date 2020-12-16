package lotto.domain.numbers;

import lotto.domain.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Rank matchWinningLottoNumbers(final WinningLottoTicket winningLottoTicket) {
        return Rank.valueOf(calculateMatchCount(winningLottoTicket), isMatchBonusNumber(winningLottoTicket));
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void validateSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> noDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (noDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("중복된 로또 번호가 있습니다.");
        }
    }

    private int calculateMatchCount(WinningLottoTicket winningLottoTicket) {
        return (int) lottoNumbers.stream()
                .filter(winningLottoTicket::isContain)
                .count();
    }

    private boolean isMatchBonusNumber(WinningLottoTicket winningLottoTicket) {
        return lottoNumbers.stream()
                .map(winningLottoTicket::isMatchBonusNumber)
                .filter(aBoolean -> aBoolean)
                .findAny()
                .orElse(false);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
