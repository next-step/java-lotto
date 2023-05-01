package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;

import java.util.Arrays;

public class LottoResult {
    private static final int MINIMUM_COUNT_BOUND = 0;
    private static final int MINIMUM_WINNING_COUNT = 3;

    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public long getMatchingLottosCount(int sameNumberCount) {
        checkCountRange(sameNumberCount);

        return lottos.getLottoList()
                .stream()
                .map(this::getMatchingLottoSameNumberCount)
                .filter(it -> it == sameNumberCount)
                .count();
    }

    private void checkCountRange(int count) {
        if (count >= MINIMUM_COUNT_BOUND &&
                count <= Lotto.LOTTO_NUMBER_SIZE) {
            return;
        }

        throw new InvalidLottoMatchingCountException("입력한 갯수 : ", String.valueOf(count));
    }

    private long getMatchingLottoSameNumberCount(Lotto lotto) {
        return Arrays.stream(lotto.getLottoNumbers())
                .takeWhile(winningLotto::hasNumber)
                .count();
    }

    public double getProfitRate() {
        long price = 0;
        for (int i = MINIMUM_WINNING_COUNT; i <= Lotto.LOTTO_NUMBER_SIZE; i++) {
            LottoPrize lottoPrize = LottoPrize.from(i);
            price += lottoPrize.getPrize() * getMatchingLottosCount(i);
        }
        return price / (double) (lottos.getLottoQuantity() * LottoShop.LOTTO_PRICE);
    }
}
