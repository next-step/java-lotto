package lotto.domain;

import lotto.Count;
import lotto.Money;
import lotto.controller.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final Money LOTTO_PRICE = new Money(1000);

    public Count matchPriceAndPayment(Money input) {
        return new Count(input / LOTTO_PRICE);
    } //TODO: count에 연산 기능 추가

    public List<LottoTicket> buyLotto(Money input) {
        List<LottoTicket> lottos = new ArrayList<>();
        Count lottoCnt = matchPriceAndPayment(input);
        for (int i = 0; i < lottoCnt; i++) { // TODO: Count에 getter를 줘야 하나??  for문 자체를 Count 메서드로 만드는 건 이치에 맞지 않아 보인느데
            lottos.add(LottoGenerator.generateLotto(i));
        }
        return lottos;
    }
}
