package lotto.generator;

import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleGenerator implements LottoGenerator {
    private final List<LottoGenerator> lottoGenerators;

    public LottoBundleGenerator(int buyingMoney, List<String> manualLottoValues) {
        this(new Money(buyingMoney), manualLottoValues);
    }

    public LottoBundleGenerator(Money buyingMoney, List<String> manualLottoValues) {
        this(createLottoGenerators(buyingMoney, manualLottoValues));
    }

    public LottoBundleGenerator(List<LottoGenerator> lottoGenerators) {
        this.lottoGenerators = lottoGenerators;
    }

    private static List<LottoGenerator> createLottoGenerators(Money buyingMoney, List<String> manualLottoValues) {
        List<LottoGenerator> lottoGenerators = new ArrayList<>();
        lottoGenerators.add(new ManualLottoGenerator(manualLottoValues));
        lottoGenerators.add(new AutoLottoGenerator(buyingMoney.subtractPurchaseAmount(manualLottoValues.size())));
        return lottoGenerators;
    }

    @Override
    public Lottos generate() {
        Lottos lottos = new Lottos();
        for (LottoGenerator lottoGenerator : lottoGenerators) {
            lottos.addLottos(lottoGenerator.generate());
        }
        return lottos;
    }
}
