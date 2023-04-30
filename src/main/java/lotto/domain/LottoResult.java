package lotto.domain;

import java.util.Arrays;

public class LottoResult {
    private static final int MINIMUM_COUNT_BOUND = 0;
    private static final int MINIMUM_WINNING_COUNT = 3;
    private static final String INVALID_COUNT_ERROR_MESSAGE = "적절한 입력이 아닙니다.";

    private final Lottos lottos;
    private final Lotto winningLotto;

    public LottoResult(Lottos lottos, Lotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public long getMatchingLottosCount(int sameNumberCount) {
        if (!isValidCount(sameNumberCount)) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR_MESSAGE);
        }

        return lottos.getLottoList()
                .stream()
                .map(this::getMatchingLottoSameNumberCount)
                .filter(it -> it == sameNumberCount)
                .count();
    }

    private boolean isValidCount(int count) {
        return count >= MINIMUM_COUNT_BOUND &&
                count <= Lotto.LOTTO_NUMBER_SIZE;
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
