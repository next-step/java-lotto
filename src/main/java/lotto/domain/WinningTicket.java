package lotto.domain;

import lotto.view.WinningRequestDto;

import java.util.Objects;

public class WinningTicket {
    private static final int COUNT_ONE = 1;

    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningTicket(WinningRequestDto winningDto) {
        this(winningDto.getLottoNumbers(), winningDto.getBonusNumber());
    }

    public WinningTicket(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new BonusNumber(lottoNumbers, bonusNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isMatchBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers()
                .stream()
                .filter(lottoNumber -> lottoNumber.isEqualBonusNumber(bonusNumber))
                .count() == COUNT_ONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningTicket)) return false;
        WinningTicket that = (WinningTicket) o;
        return getLottoNumbers().getLottoNumbers().containsAll(that.getLottoNumbers().getLottoNumbers()) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers(), bonusNumber);
    }
}
