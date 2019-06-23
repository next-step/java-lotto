package lotto.domain;

import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.RandomLottosGenerator;

import java.util.List;

public class Lottos {

    public static final int AMOUNT_PER_LOTTO = 1000;
    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {

        this(new RandomLottosGenerator(), purchaseAmount);
    }

    public Lottos(LottosGenerator lottosGenerator, int purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);
        int lottoCount = purchaseAmount / AMOUNT_PER_LOTTO;
        lottos = lottosGenerator.generate(lottoCount);
        validateGeneratedLottosCount(lottoCount);
    }

    public long getWonNumbersCorrectCount(int correctCount, WonNumbers wonNumbers) {

        return lottos.stream()
                .filter(lotto -> lotto.isLottoNumberMatchesCorrectCount(correctCount, wonNumbers))
                .count();
    }

    public int getLottoCount() {

        return lottos.size();
    }

    private void validatePurchaseAmount(int purchaseAmount) {

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다. 구매금액=" + purchaseAmount);
        }
        if (purchaseAmount % AMOUNT_PER_LOTTO != 0) {
            throw new IllegalArgumentException("로또구매는 " + AMOUNT_PER_LOTTO + "원 단위로만 가능합니다. 구매금액=" + purchaseAmount);
        }
    }

    private void validateGeneratedLottosCount(int lottoCount) {

        if (lottos.size() != lottoCount) {
            throw new IllegalStateException("생성된 로또 개수가 유효하지 않습니다. 생성된 개수=" + lottos.size() + ", 기대한 개수=" + lottoCount);
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
