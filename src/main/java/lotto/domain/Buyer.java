package lotto.domain;

import lotto.wrapper.Count;
import lotto.wrapper.Money;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public Count matchPriceAndPayment(Money input) {
        return new Count( input.getMoney() / Constants.LOTTO_PRICE.getMoney() );
    }

    public List<LottoTicket> buyLotto(Money input) {
        List<LottoTicket> lottos = new ArrayList<>();
        Count lottoCount = matchPriceAndPayment(input);
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(LottoGenerator.generateLotto(i));
        }
        return lottos;
    }
}
