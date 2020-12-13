package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidLottoShopException;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final Money money;
    private final List<LottoTicket> staticBoughtLottoTickets = new ArrayList<>();

    public LottoShop(final Money money) {
        validate(money);
        this.money = money;
    }

    private void validate(final Money money) {
        if (!money.isEnoughToBuyTicket()) {
            throw new InvalidLottoShopException("최소 1장 이상의 로또를 살 금액을 갖고 와야 합니다.");
        }
    }
}
