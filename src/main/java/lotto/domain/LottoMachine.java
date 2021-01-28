package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public int getLottoTicketNumber(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}
