package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.LottoNumberGenerator;

public class LottoShop {

    private final Integer LOTTO_PRICE = 1000;

    public List<LottoTicket> buyLotto(int money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++){
            lottoTickets.add(new LottoTicket(LottoNumberGenerator.getRandomLottoNumber()));
        }
        return lottoTickets;
    }

    public Integer getLottoPrice() {
        return LOTTO_PRICE;
    }
}
