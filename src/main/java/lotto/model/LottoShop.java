package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.LottoNumberGenerator;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;

    public LottoWallet buy(int money) {
        return getLottoNumbers(buyChance(money));
    }

    public int buyChance(int money) {
        return money / LOTTO_PRICE;
    }

    public LottoWallet getLottoNumbers(int size) {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumberGenerator());

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(lottoGenerator.generate());
        }

        return new LottoWallet(lottos);
    }
}
