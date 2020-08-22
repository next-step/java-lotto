package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private LottoTicket winningLottoNumber;

    public WinningLotto(Set<LottoNumber> lottoNumbers) {
        this.winningLottoNumber = new LottoTicket(lottoNumbers);
    }

    public LottoTicket getWinningLottoNumber() {
        return winningLottoNumber;
    }
}
