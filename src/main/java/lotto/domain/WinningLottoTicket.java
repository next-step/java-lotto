package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {

    private final LottoTicket winningLottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLottoTicket(List<Integer> winningLottoNumbers, int bonusNumber) {
        this(winningLottoNumbers, new LottoNumber(bonusNumber));
    }

    public WinningLottoTicket(List<Integer> winningLottoNumbers, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = winningLottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());

        this.winningLottoNumbers = new LottoTicket(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int contains(LottoNumber lottoNumber) {
        if (winningLottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
