package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinningType {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchNumbersCount;
    private final long winningAmount;

    LottoWinningType(final int matchNumbersCount, final long winningAmount) {
        this.matchNumbersCount = matchNumbersCount;
        this.winningAmount = winningAmount;
    }

    public static LottoWinningType valueOfMatchNumbersCount(final int matchNumbersCount) {
        return Arrays.stream(values())
                     .filter(lottoWinningType -> lottoWinningType.matchNumbersCount == matchNumbersCount)
                     .findFirst()
                     .orElse(NONE);
    }

    public int getMatchNumbersCount() {
        return matchNumbersCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public static List<LottoWinningType> valuesByMatchNumbersCountAsc() {
        return Arrays.stream(LottoWinningType.values())
                     .sorted((type1, type2) -> {
                         if (type1.matchNumbersCount == type2.matchNumbersCount) {
                             return 0;
                         }

                         return type1.matchNumbersCount < type2.matchNumbersCount ? -1 : 1;
                     })
                     .collect(Collectors.toList());
    }
}
