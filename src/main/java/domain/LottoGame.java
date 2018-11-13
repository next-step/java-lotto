package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;

    public LottoGame() {
        lottos = new ArrayList<>();
    }

    public void buyLotto(int price) {
        for (int i = 0; i < getSizeOfLotto(price); i++) {
            lottos.add(Lotto.auto());
        }
    }

    private int getSizeOfLotto(int price) {
        return price / Lotto.PRICE;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getBoughtLottos() {
        return lottos;
    }
}
