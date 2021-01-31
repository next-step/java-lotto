package lotto.domain;

import lotto.Count;
import lotto.Money;
import lotto.controller.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final Money LOTTO_PRICE = new Money(1000);

    public Count matchPriceAndPayment(Money input) {
        return new Count( input.getMoney() / LOTTO_PRICE.getMoney() );
    }

    public List<LottoTicket> buyLotto(Money input) {
        List<LottoTicket> lottos = new ArrayList<>();
        Count lottoCnt = matchPriceAndPayment(input);
        for (int i = 0; i < lottoCnt.getCount(); i++) {
            lottos.add(LottoGenerator.generateLotto(i));
        }
        return lottos;
    }
}
