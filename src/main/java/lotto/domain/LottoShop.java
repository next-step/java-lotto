package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.LottoNumberGenerator;
import lotto.common.LottoValidator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public LottoTickets buyLotto(int money, List<List<Integer>> manualNumber) {
        LottoValidator.validatePurchase(money, LOTTO_PRICE, manualNumber.size());
        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < manualNumber.size(); i++) {
            lottoTickets.addLottoTicket(new LottoTicket(manualNumber.get(i)));
        }

        for (int i = 0; i < (money / LOTTO_PRICE) - manualNumber.size(); i++) {
            lottoTickets.addLottoTicket(new LottoTicket(LottoNumberGenerator.getRandomLottoNumber()));
        }

        return lottoTickets;
    }

    public Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

}
