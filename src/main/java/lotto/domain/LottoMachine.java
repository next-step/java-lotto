package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public LottoPaper buyLotto(Money money, List<String> customLottos) {

        List<Lotto> lottos = new ArrayList<>();

        for (String customLotto : customLottos) {
            lottos.add(new CustomLottoGenerator(customLotto).generateLotto());
        }

        for (int i = 0; i < money.countOfLottoPurchases(); i++) {
            lottos.add(new AutoLottoGenerator().generateLotto());
        }

        return new LottoPaper(lottos);
    }

}
