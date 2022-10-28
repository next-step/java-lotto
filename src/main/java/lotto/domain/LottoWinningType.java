package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinningType {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
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
                     .sorted(Comparator.comparingInt(LottoWinningType::getMatchNumbersCount))
                     .collect(Collectors.toList());
    }
}
