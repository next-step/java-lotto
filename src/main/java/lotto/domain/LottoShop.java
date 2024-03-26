package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.common.LottoNumberGenerator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public List<LottoTicket> buyLotto(int money) {
        validate(money);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++){
            lottoTickets.add(new LottoTicket(LottoNumberGenerator.getRandomLottoNumber()));
        }
        return lottoTickets;
    }

    public Integer getLottoPrice() {
        return LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("로또의 가격은 %s 입니다.", LOTTO_PRICE));
        }
    }
}
