package step2.domain.lotto;

import java.util.List;

public class LottoGame {

    public static LottoWinningRank playLotto(List<LottoTicket> userLottoTickets, LottoTicket winningLottoTicket) {
        LottoWinningRank lottoWinningRank = new LottoWinningRank();
        for (LottoTicket userLottoTicket : userLottoTickets) {
            lottoWinningRank.createStatistics(userLottoTicket.findMatchingCount(winningLottoTicket));
        }
        return lottoWinningRank;
    }
}
