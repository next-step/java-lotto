package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoWrapper buyLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money / Config.LOTTO_PRICE;
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(new Lotto(NumberGenerator.pickLottoNumber()));
        }
        return new LottoWrapper(lottos);
    }
}
