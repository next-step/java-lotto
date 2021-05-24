package lotto.domain;

import lotto.common.WinningType;
import java.util.List;

public class LottoGamePlayer {

    public List<WinningType> play(LottoTicket winningLotto, LottoTickets lottoTickets) {
        return lottoTickets.getWinningTypes(winningLotto);
    }
}
