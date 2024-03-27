package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.LottoNumberGenerator;
import lotto.common.LottoValidator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> buyLotto(int money) {
        LottoValidator.validatePurchase(money, LOTTO_PRICE);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoTickets.add(new LottoTicket(LottoNumberGenerator.getRandomLottoNumber()));
        }
        return lottoTickets;
    }

    public Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

}
