package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static final int MONEY_UNIT = 1000;

    private LottoGenerator() {
        /* no-op */
    }

    public static List<List<Integer>> generateLottoContents(final long money, final CandidateStrategy candidateStrategy) {
        validateMoneyUnit(money);

        final List<List<Integer>> lottoContents = new ArrayList<>();
        for (long count = 0, maxCount = money / MONEY_UNIT; count < maxCount; count++) {
            lottoContents.add(generateOne(candidateStrategy));
        }

        return lottoContents;
    }

    public static List<Integer> generateOne(CandidateStrategy candidateStrategy) {
        final List<Integer> candidates = candidateStrategy.generateCandidates();

        return candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT);
    }

    private static void validateMoneyUnit(final long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("구입금액은 " + MONEY_UNIT + "원 단위여야 합니다.");
        }
    }
}
