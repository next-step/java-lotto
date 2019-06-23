package lotto.domain;

import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.RandomLottosGenerator;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(PurchaseAmount purchaseAmount) {

        this(new RandomLottosGenerator(), purchaseAmount);
    }

    public Lottos(LottosGenerator lottosGenerator, PurchaseAmount purchaseAmount) {

        this.lottos = lottosGenerator.generate(purchaseAmount.getPurchasedLottosCount());
        validateGeneratedLottosCount(purchaseAmount.getPurchasedLottosCount());
    }

    public long countCorrectsByCompareWonNumbers(int corrects, WonNumbers wonNumbers) {

        return lottos.stream()
                .filter(lotto -> lotto.countCorrectsByCompareWonNumbers(corrects, wonNumbers))
                .count();
    }

    public int getLottoCount() {

        return lottos.size();
    }

    private void validateGeneratedLottosCount(int lottosCount) {

        if (lottos.size() != lottosCount) {
            throw new IllegalStateException("생성된 로또 개수가 유효하지 않습니다. 생성된 개수=" + lottos.size() + ", 기대한 개수=" + lottosCount);
        }
    }

    @Override
    public String toString() {

        return lottos.stream()
                .map(Lotto::toString)
                .reduce((lotto1, lotto2) -> lotto1 + "\n" + lotto2)
                .orElseThrow(IllegalStateException::new);
    }
}
