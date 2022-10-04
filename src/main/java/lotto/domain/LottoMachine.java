package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> buyLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / Config.LOTTE_PRICE;
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
