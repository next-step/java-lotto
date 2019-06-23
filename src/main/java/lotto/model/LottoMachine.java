package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> sellTo(Money money) {
        
        long count = money.countAvailable(Money.wons(1000));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(NumberGenerator.getLotto());
        }
        return lottos;
    }
}
