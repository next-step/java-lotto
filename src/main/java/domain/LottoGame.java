package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame() {
        lottos = new ArrayList<>();
    }

    public void buyLotto(int price) {
        for (int i = 0; i < price / Lotto.PRICE; i++) {
            lottos.add(new Lotto());
        }
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
