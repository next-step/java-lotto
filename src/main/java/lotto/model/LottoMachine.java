package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static LottoTicket buy(Money money) {
        long count = money.countAvailable(Lotto.PRICE);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return LottoTicket.of(lottos);
    }
}
