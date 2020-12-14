package lotto;

import java.util.Set;

public class WinningLotto {

    private final LottoTicket winningLottoTicket;

    private WinningLotto(Set<LottoNumber> lottoNumbers) {
        this.winningLottoTicket = new LottoTicket(lottoNumbers);
    }

    public static WinningLotto ofLottoNumbers(Set<LottoNumber> lottoNumbers) {
        return new WinningLotto(lottoNumbers);
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }
}
