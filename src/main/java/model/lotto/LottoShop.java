package model.lotto;

import generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int LOTTO_PER_AMOUNT = 1000;
    private final NumberGenerator numberGenerator;

    public LottoShop(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generateLotto(LottoCount lottoCount, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int index = 0; index < lottoCount.getAutoCount(); index++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return lottos;
    }

    private int getLottoCounts(int price) {
        if(price < LOTTO_PER_AMOUNT) {
            throw new IllegalArgumentException("구입 금액은 1000원을 넘어야합니다.");
        }
        return price / LOTTO_PER_AMOUNT;
    }
}
