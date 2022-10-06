package lottogame.domain.user;

import java.util.ArrayList;
import java.util.List;

import lottogame.domain.Money;
import lottogame.domain.lotto.LottoTicket;

public class User {
    private Money money;
    private final List<LottoTicket> lottoTickets;

    public User(Money money) {
        this.money = money;
        this.lottoTickets = new ArrayList<>();
    }

    public boolean hasEnoughMoney(Money money) {
        return this.money.isGreaterThanOrEqual(money);
    }

    public boolean hasTickets() {
        return !lottoTickets.isEmpty();
    }

    public void buyTicket(LottoTicket lottoTicket, Money ticketPrice) {
        money = money.minus(ticketPrice);
        lottoTickets.add(lottoTicket);
    }

    public Money getMoney() {
        return money;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
