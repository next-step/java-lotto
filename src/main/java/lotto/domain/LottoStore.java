package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    private LottoGenerator lottoGenerator;

    public LottoStore(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<BasicLotto> buyLottos(int money) {
        int tryCount = convertMoneyToTryCount(money);
        List<BasicLotto> lottos = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottos.add(new BasicLotto(this.lottoGenerator.generate()));
        }
        return lottos;
    }

    private int convertMoneyToTryCount(int money) {
        if (money < 0)
            throw new IllegalArgumentException();

        return money / LOTTO_PRICE;
    }
}
