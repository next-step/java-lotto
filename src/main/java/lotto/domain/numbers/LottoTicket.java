package lotto.domain.numbers;

import lotto.domain.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Rank matchWinningLottoNumbers(final WinningLottoNumbers winningNumbers) {
        return Rank.valueOf(calculateCount(winningNumbers), isMatchBonusNumber(winningNumbers));
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

    private int calculateCount(WinningLottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::isContain)
                .count();
    }

    private boolean isMatchBonusNumber(WinningLottoNumbers winningNumbers) {
        return lottoNumbers.stream()
                .map(winningNumbers::isMatchBonusNumber)
                .filter(aBoolean -> aBoolean)
                .findAny()
                .orElse(false);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
