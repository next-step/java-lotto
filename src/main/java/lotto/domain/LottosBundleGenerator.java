package lotto.domain;

import java.util.List;

public class LottosBundleGenerator implements LottoGenerator {

    private final List<LottoGenerator> generators;

    public LottosBundleGenerator(Money money, List<String> manualLottos) {
        this(toLottosGenerators(money, manualLottos));
    }

    public LottosBundleGenerator(List<LottoGenerator> generators) {
        this.generators = generators;
    }

    private static List<LottoGenerator> toLottosGenerators(Money money, List<String> manualLottos) {
        ManualLottoGenerator manualLottoGenerator = ManualLottoGenerator.from(manualLottos);
        int manualCount = manualLottos.size();

        Money remainMoney = money.minus(manualCount);
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(new LottoCount(remainMoney));

        return List.of(manualLottoGenerator, autoLottoGenerator);
    }

    @Override
    public Lottos generate() {
        return generators.stream()
                .map(LottoGenerator::generate)
                .reduce(Lottos::merge)
                .orElseGet(Lottos::empty);
    }
}
