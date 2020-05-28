package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum LottoRank {
    RANK1(6, BigDecimal.valueOf(2000000000)),
    RANK2(5, BigDecimal.valueOf(1500000)),
    RANK3(4, BigDecimal.valueOf(50000)),
    RANK4(3, BigDecimal.valueOf(5000)),
    BOOM(0, BigDecimal.ZERO);

    private int containCount;
    private BigDecimal winningAmount;

    private static final Map<Integer, LottoRank> lottoRanks =
            Collections.unmodifiableMap(
                    Arrays.stream(values()).collect(Collectors.toMap(LottoRank::getContainCountsSameWinningNumber, Function.identity())));

    LottoRank(int containCount, BigDecimal amount)
    {
        this.containCount = containCount;
        this.winningAmount = amount;
    }

    public static LottoRank getRank(int containCount) {
        LottoRank lottoRank = lottoRanks.get(containCount);
        if(lottoRank == null) {
            lottoRank = BOOM;
        }
        return lottoRank;
    }

    public static LottoRank[] getWinningLotto() {
        return new LottoRank[] {RANK1, RANK2, RANK3, RANK4};
    }

    public int getContainCountsSameWinningNumber() {
        return containCount;
    }

    public BigDecimal getWinningAmount() {
        return winningAmount;
    }
}
