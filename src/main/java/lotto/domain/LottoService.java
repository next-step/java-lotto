package lotto.domain;

import lotto.domain.model.game.LottoGame;
import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.PurchaseAmount;
import lotto.domain.model.lotto.TicketCount;
import lotto.domain.model.lotto.BonusNumber;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.LottoTicketFactory;
import lotto.domain.model.lotto.TicketPrice;
import lotto.domain.model.lotto.WinningLottoTicket;

import java.util.List;
import java.util.Set;

public class LottoService {

    private final LottoTicketFactory ticketFactory = new LottoTicketFactory();

    public List<LottoTicket> purchaseTickets(final int purchaseAmount) {
        return purchaseTickets(new PurchaseAmount(purchaseAmount));
    }
    
    public List<LottoTicket> purchaseTickets(final PurchaseAmount amount) {
        TicketCount ticketCount = TicketCount.from(amount, TicketPrice.standard());
        return ticketFactory.create(ticketCount.getCount());
    }

    public WinningLottoTicket createWinningTicket(
            final Set<LottoNumber> winningNumbers, final BonusNumber bonusLottoNumber) {
        return ticketFactory.createWinning(winningNumbers, bonusLottoNumber);
    }

    public LottoGameResult draw(final List<LottoTicket> lottoTickets, final WinningLottoTicket winningLottoTicket) {
        return new LottoGame(lottoTickets, winningLottoTicket).draw();
    }

}
