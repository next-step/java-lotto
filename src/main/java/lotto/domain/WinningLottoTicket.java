package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class WinningLottoTicket {

    private final LottoTicket winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoTicket(final List<Integer> winningLottoNumbers, final int bonusNumber) {
        this(winningLottoNumbers, new LottoNumber(bonusNumber));
    }

    public WinningLottoTicket(final List<Integer> winningLottoNumbers, final LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = winningLottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());

        this.winningLottoNumbers = new LottoTicket(lottoNumbers);
        this.bonusNumber = bonusNumber;

        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("bonus number must not in winning numbers");
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return winningLottoNumbers.contains(lottoNumber);
    }

    public boolean containsBonusNumber(final LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
