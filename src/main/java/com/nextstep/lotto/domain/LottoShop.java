package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoShopException;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final Money originalMoney;
    private final List<LottoTicket> staticBoughtLottoTickets = new ArrayList<>();

    public LottoShop(final Money originalMoney) {
        validate(originalMoney);
        this.originalMoney = originalMoney;
    }

    public void buyStaticLottoTicket(LottoTicket staticBoughtLottoTicket) {
        validateCanBuy();
        staticBoughtLottoTickets.add(staticBoughtLottoTicket);
    }

    public LottoTickets buyAutoLottoTicketsByRemainedMoney() {
        return LottoTicketsFactory.creatAutoByRemainedMoney(originalMoney, new LottoTickets(staticBoughtLottoTickets));
    }

    public int howManyStaticBoughtLottoTickets() {
        return staticBoughtLottoTickets.size();
    }

    public Money getRemainedMoney() {
        return originalMoney.minusBoughtLottoTickets(staticBoughtLottoTickets.size());
    }

    private void validateCanBuy() {
        if (originalMoney.howManyLottoTickets() <= staticBoughtLottoTickets.size() + 1) {
            throw new InvalidLottoShopException("제시된 금액보다 수동으로 LottoTicket을 더 많이 살 수 없습니다.");
        }
    }

    private void validate(final Money money) {
        if (!money.isEnoughToBuyTicket()) {
            throw new InvalidLottoShopException("최소 1장 이상의 로또를 살 금액을 갖고 와야 합니다.");
        }
    }
}
