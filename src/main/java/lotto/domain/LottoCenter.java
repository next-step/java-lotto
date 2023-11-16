package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCenter {

    public static final int PRICE = 1000;

    public int buyLotto(int cash) {
        return cash / PRICE;
    }

    public List<Lotto> generateTicket(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
