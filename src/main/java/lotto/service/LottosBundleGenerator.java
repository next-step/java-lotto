package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

public class LottosBundleGenerator implements LottosGenerator {
    private final List<LottosGenerator> generators;

    public LottosBundleGenerator(LottoPurchase lottoPurchase, List<String> manualLottoText) {
        this(toLottosGenerators(lottoPurchase, manualLottoText));
    }

    public LottosBundleGenerator(List<LottosGenerator> generators) {
        this.generators = generators;
    }

    @Override
    public Lottos generate() {
        return generators.stream()
            .map(LottosGenerator::generate)
            .reduce(Lottos::merge)
            .orElse(new Lottos(List.of()));
    }

    private static List<LottosGenerator> toLottosGenerators(LottoPurchase purchase, List<String> manualLottoText) {
      Lottos manualLottos = parseManualLottos(manualLottoText);
      purchase.validateManualCount(manualLottos.size());

      LottosGenerator manual = new ManualLottosGenerator(manualLottos);
      LottosGenerator auto = new AutoLottosGenerator(purchase.size() - manualLottos.size());

      return List.of(manual, auto);
    }

    private static Lottos parseManualLottos(List<String> manualLottoText) {
        List<Lotto> lottos = manualLottoText.stream()
                .map(LottosBundleGenerator::parseLotto)
                .toList();
        return new Lottos(lottos);
    }

    private static Lotto parseLotto(String lottosText) {
        List<Integer> numbers = Arrays.stream(lottosText.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }
}
