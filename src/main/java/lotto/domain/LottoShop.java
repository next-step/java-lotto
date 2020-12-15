package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int MINIMUN_AMOUNT = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();
    private final NumberPool numberPool = new NumberPool();

    public List<Lotto> getLottos(int money) {
        if(money < MINIMUN_AMOUNT) {
            throw new NotEnoughMoneyException("돈이 부족합니다.");
        }
        int buyCnt = money/LOTTO_PRICE;
        return generateLotto(buyCnt);
    }

    private List<Lotto> generateLotto(int buyCnt) {
        for(int i = 0; i < buyCnt; i++) {
            Lotto lotto = new Lotto(numberPool.getLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
