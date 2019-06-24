package lotto.domain;

import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.RandomLottosGenerator;
import lotto.domain.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final RandomLottosGenerator RANDOM_LOTTOS_GENERATOR = new RandomLottosGenerator();
    private final List<Lotto> lottos;

    public Lottos(PurchaseAmount purchaseAmount, List<String> manualNumbers) {

        this(RANDOM_LOTTOS_GENERATOR, purchaseAmount, manualNumbers);
    }

    public Lottos(LottosGenerator lottosGenerator, PurchaseAmount purchaseAmount, List<String> manualNumbers) {

        List<Lotto> lottos = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            List<Integer> lottoNumber = LottoParser.parse(manualNumber);
            LottoValidator.validateNumbers(lottoNumber);
            lottos.add(new Lotto(lottoNumber));
        }
        lottos.addAll(lottosGenerator.generate(purchaseAmount.getPurchasedLottosCount() - manualNumbers.size()));
        LottoValidator.validateLottosCount(lottos.size(), purchaseAmount.getPurchasedLottosCount());
        this.lottos = lottos;
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
