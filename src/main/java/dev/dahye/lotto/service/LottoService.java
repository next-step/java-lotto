package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MUST_BE_REMAINDER = 0;
    private final List<LottoTicket> lottoTickets;

    public LottoService(int money) {
        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;
        this.lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(LottoTicket.create());
        }
    }

    private void validateMoney(int money) {
        if (isNoRemainder(money)) {
            throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
        }
    }

    private boolean isNoRemainder(int money) {
        return money % LOTTO_PRICE != MUST_BE_REMAINDER;
    }

    public int getTotalCount() {
        return lottoTickets.size();
    }
}
