package lottogame.domain.user;

import java.util.ArrayList;
import java.util.List;

import lottogame.domain.Money;
import lottogame.domain.lotto.LottoTicket;

public class User {
    private Money money;
    private final List<LottoTicket> lottoTickets;
    private final int manualTicketCount;

    public User(Money money) {
        this(money, 0);
    }

    public User(Money money, int manualTicketCount) {
        validate(manualTicketCount);
        this.money = money;
        this.lottoTickets = new ArrayList<>();
        this.manualTicketCount = manualTicketCount;
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

    private void validate(int manualTicketCount) {
        if (manualTicketCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 음수가 될 수 없습니다.");
        }
    }

    public Money getMoney() {
        return money;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
