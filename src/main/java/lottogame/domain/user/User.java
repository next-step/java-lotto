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
        this.money = money;
        this.lottoTickets = new ArrayList<>();
        this.manualTicketCount = manualTicketCount;
    }

    public void validateManualTicketCondition(Money ticketPrice) {
        if (manualTicketCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 음수가 될 수 없습니다.");
        }

        if (!hasEnoughMoney(ticketPrice.times(manualTicketCount))) {
            throw new IllegalArgumentException("입력한 갯수의 수동 로또 구입에 필요한 돈이 충분하지 않습니다.");
        }
    }

    public void checkValidTicketBuying() {
        if (lottoTickets.isEmpty()) {
            throw new IllegalStateException("소지 금액이 부족합니다.");
        }
    }

    public boolean hasEnoughMoney(Money money) {
        return this.money.isGreaterThanOrEqual(money);
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

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutomaticTicketCount() {
        return lottoTickets.size() - getManualTicketCount();
    }
}
