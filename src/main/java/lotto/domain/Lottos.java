package lotto.domain;

import lotto.domain.generator.LottosGenerator;
import lotto.domain.generator.RandomLottosGenerator;

import java.util.List;

public class Lottos {

    private static final int AMOUNT_PER_LOTTO = 1000;
    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {

        this(new RandomLottosGenerator(), purchaseAmount);
    }

    public Lottos(LottosGenerator lottosGenerator, int purchaseAmount) {

        validate(purchaseAmount);
        lottos = lottosGenerator.generate(purchaseAmount / AMOUNT_PER_LOTTO);
    }

    public long getWonNumbersCorrectCount(int correctCount, WonNumbers wonNumbers) {

        return lottos.stream()
                .filter(lotto -> lotto.isLottoNumberMatchesCorrectCount(correctCount, wonNumbers))
                .count();
    }

    public int getLottoCount() {

        return lottos.size();
    }

    private void validate(int purchaseAmount) {

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다. 구매금액=" + purchaseAmount);
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
