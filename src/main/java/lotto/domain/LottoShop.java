package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private LottoShop() {

    }

    public static LottoSet buy(int amount) {
        int numberOfBuy = numberOfBuy(Money.create(amount), 0);
        List<Lotto> lottos = new AutomaticLottoGenerator(numberOfBuy).create();
        return LottoSet.create(lottos);
    }

    public static LottoSet buy(LottoWallet lottoWallet) {
        List<Lotto> manualLottos = lottoWallet.getManualLottos();
        int numberOfBuy = numberOfBuy(lottoWallet.getMoney(), manualLottos.size());

        List<LottoGenerator> generators = init(numberOfBuy, manualLottos);
        return LottoSet.generate(generators);
    }

    public static int numberOfBuy(Money money, int numberOfManualLottos) {
        return money.numberOfBuy(LOTTO_PRICE) - numberOfManualLottos;
    }

    public static List<LottoGenerator> init(int numberOfBuy, List<Lotto> manualLottos) {
        List<LottoGenerator> generators = new ArrayList<>();
        generators.add(new AutomaticLottoGenerator(numberOfBuy));
        generators.add(new ManualLottoGenerator(manualLottos));
        return generators;
    }
}
