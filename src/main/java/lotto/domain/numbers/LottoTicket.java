package lotto.domain.numbers;

import lotto.domain.Rank;

import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public Rank matchWinningLottoNumbers(final WinningLottoNumbers winningNumbers) {
        return Rank.valueOf(calculateCount(winningNumbers), isMatchBonusNumber(winningNumbers));
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자가 부족합니다.");
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
