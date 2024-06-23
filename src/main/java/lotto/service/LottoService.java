package lotto.service;

import lotto.model.*;

public class LottoService {
    public LottoResult calculateResult(LottoTicketBundle userLottoTikcets, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (LottoTicket lotto : userLottoTikcets.getLottoTickets()) {
            int matchCount = winningLotto.match(lotto);
            lottoResult.addRank(LottoRank.valueOf(matchCount, lotto.contains(winningLotto.getBonusNumber())));
        }
        return lottoResult;
    }

    public LottoTicketBundle createAutoLottoTickets(int payAmount, int manualLottoTicketCount) {
        int autoLottoTicketCount
                = (payAmount - (LottoTicket.LOTTO_TICKET_PRICE * manualLottoTicketCount)) / LottoTicket.LOTTO_TICKET_PRICE;
        return LottoTicketBundle.create(autoLottoTicketCount * LottoTicket.LOTTO_TICKET_PRICE);
    }
}
