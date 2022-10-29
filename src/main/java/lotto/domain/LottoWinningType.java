package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinningType {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchNumbersCount;
    private final boolean matchBonusNumber;
    private final long winningAmount;

    LottoWinningType(final int matchNumbersCount, final boolean matchBonusNumber, final long winningAmount) {
        this.matchNumbersCount = matchNumbersCount;
        this.matchBonusNumber = matchBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static LottoWinningType valueOf(final int matchNumbersCount, final boolean matchBonus) {
        return Arrays.stream(values())
                     .filter(lottoWinningType -> lottoWinningType.matchNumbersCount == matchNumbersCount
                             && lottoWinningType.matchBonusNumber == matchBonus)
                     .findFirst()
                     .orElse(NONE);
    }

    public int getMatchNumbersCount() {
        return matchNumbersCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public static List<LottoWinningType> valuesByMatchNumbersCountAsc() {
        return Arrays.stream(LottoWinningType.values())
                     .sorted(Comparator.comparing(LottoWinningType::getMatchNumbersCount)
                                       .thenComparing(LottoWinningType::getWinningAmount))
                     .collect(Collectors.toList());
    }
}
