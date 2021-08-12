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
    }

    public int contains(final LottoNumber lottoNumber) {
        if (winningLottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean containsBonusNumber(final LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
