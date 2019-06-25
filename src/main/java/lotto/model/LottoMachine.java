package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.RandomLottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Lotto> buyLotto(Money money) {
        long countOfLotto = money.countAvailable(Lotto.PRICE);
        LottoGenerator lottoGenerator = new RandomLottoGenerator();
        List lottos = new ArrayList();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(lottoGenerator.generator());
        }
        return lottos;
    }
}
