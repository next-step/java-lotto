package lotto.domain;

import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.RandomLottosGenerator;
import lotto.domain.validator.LottoValidator;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private static final RandomLottosGenerator RANDOM_LOTTOS_GENERATOR = new RandomLottosGenerator();
    private final List<Lotto> lottos;

    public Lottos(PurchaseAmount purchaseAmount, List<String> manualNumbers) {

        this(RANDOM_LOTTOS_GENERATOR, purchaseAmount, manualNumbers);
    }

    public Lottos(LottosGenerator lottosGenerator, PurchaseAmount purchaseAmount, List<String> manualNumbers) {

        List<Lotto> lottos = Stream.of(buildManualLotto(manualNumbers),
                                       generateAutoLotto(lottosGenerator, purchaseAmount.getPurchasedLottosCount() - manualNumbers.size()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        LottoValidator.validateLottosCount(lottos.size(), purchaseAmount.getPurchasedLottosCount());
        this.lottos = lottos;
    }

    private List<Lotto> buildManualLotto(List<String> manualNumbers) {

        return manualNumbers.stream()
                .map(LottoParser::parse)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<Lotto> generateAutoLotto(LottosGenerator lottosGenerator, int autoCount) {

        return lottosGenerator.generate(autoCount);
    }

    public long isMatchPrizeRule(PrizeRule prizeRule, WonNumbers wonNumbers) {

        return lottos.stream()
                .filter(lotto -> lotto.isMatchPrizeRule(prizeRule, wonNumbers))
                .count();
    }

    public int getLottoCount() {

        return lottos.size();
    }

    List<Lotto> getLottos() {

        return lottos;
    }

    @Override
    public String toString() {

        return lottos.stream()
                .map(Lotto::toString)
                .reduce((lotto1, lotto2) -> lotto1 + "\n" + lotto2)
                .orElseThrow(IllegalStateException::new);
    }
}
