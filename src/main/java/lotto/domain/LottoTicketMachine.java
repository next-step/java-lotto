package lotto.domain;

import lotto.domain.strategy.LottoNumberGenerateStrategy;

import java.util.List;
import java.util.Set;

public class LottoTicketMachine {

    public List<LottoTicket> buyLottoTickets(int price, LottoNumberGenerateStrategy generateStrategy) {
        LottoTicketGenerator autoGenerateStrategy = new LottoTicketGenerator(generateStrategy);
        return autoGenerateStrategy.buyLottoTickets(price);
    }

    public WinningTicket generateWinningTicket(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        return new WinningTicket(winningNumbers, bonusNumber);
    }

}
