package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.LottoNumberGenerator;
import lotto.common.LottoValidator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public LottoTickets buyLotto(int money) {
        LottoValidator.validatePurchase(money, LOTTO_PRICE);
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoTickets.addLottoTicket(new LottoTicket(LottoNumberGenerator.getRandomLottoNumber()));
        }
        return lottoTickets;
    }

    public Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

}
