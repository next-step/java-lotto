package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    public static Lottos createLottos(int money) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        int count = money / LOTTO_PRICE;

        for(int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return new Lottos(lottos);
    }
}
