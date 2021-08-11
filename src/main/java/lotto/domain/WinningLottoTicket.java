package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {

    private final List<LottoNumber> winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoTicket(List<Integer> winningLottoNumbers, int bonusNumber) {
        this(winningLottoNumbers, new LottoNumber(bonusNumber));
    }

    public WinningLottoTicket(List<Integer> winningLottoNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(LottoNumber lottoNumber) {
        if (winningLottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean bonusBallMatch(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
