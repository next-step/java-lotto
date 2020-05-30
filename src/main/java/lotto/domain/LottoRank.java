package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    RANK1(6, false, BigDecimal.valueOf(2000000000)),
    RANK2(5, true, BigDecimal.valueOf(30000000)),
    RANK3(5, false,  BigDecimal.valueOf(1500000)),
    RANK4(4, false,  BigDecimal.valueOf(50000)),
    RANK5(3, false,  BigDecimal.valueOf(5000)),
    BOOM(0, false,  BigDecimal.ZERO);

    private final int containCount;
    private final BigDecimal winningAmount;
    private final  boolean isBonus;

    private static final List<LottoRank> lottoRanks =
            Collections.unmodifiableList(
                    Arrays.stream(values()).collect(Collectors.toList()));

    LottoRank(int containCount, boolean isBonus, BigDecimal amount)
    {
        this.containCount = containCount;
        this.winningAmount = amount;
        this.isBonus = isBonus;
    }

    public static LottoRank getRank(int containCount, boolean isBonus) {
        return lottoRanks.stream()
                .filter(lotto -> lotto.isBonus == isBonus
                        && lotto.getContainCountsSameWinningNumber() == containCount)
                .findFirst()
                .orElse(BOOM);
    }

    public static List<LottoRank> getWinningLotto() {
        return List.of(RANK1, RANK2, RANK3, RANK4, RANK5);
    }

    public int getContainCountsSameWinningNumber() {
        return containCount;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }

}
