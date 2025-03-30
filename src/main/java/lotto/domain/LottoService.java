package lotto.domain;

import lotto.domain.model.game.LottoGame;
import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.LottoTicketFactory;
import lotto.domain.model.lotto.WinningLottoTicket;

import java.util.List;
import java.util.Set;

public class LottoService {

    private static final int TICKET_PRICE = 1000;
    private final LottoTicketFactory ticketFactory = new LottoTicketFactory();

    public List<LottoTicket> purchaseTickets(final int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return ticketFactory.create(calculateTicketCount(purchaseAmount));
    }

    public WinningLottoTicket createWinningTicket(
            final Set<LottoNumber> winningNumbers, final LottoNumber bonusNumber) {
        return ticketFactory.createWinning(winningNumbers, bonusNumber);
    }

    public LottoGameResult draw(final List<LottoTicket> lottoTickets, final WinningLottoTicket winningLottoTicket) {
        return new LottoGame(lottoTickets, winningLottoTicket).draw();
    }

    private int calculateTicketCount(final int purchaseAmount) {
        return purchaseAmount / TICKET_PRICE;
    }

    private void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }

}
