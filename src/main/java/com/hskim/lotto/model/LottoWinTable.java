package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Arrays.stream;

public enum LottoWinTable {
    FIRST_PLACE(new WinningCondition(6, false), BigDecimal.valueOf(2000000000)),
    SECOND_PLACE(new WinningCondition(5, true), BigDecimal.valueOf(30000000)),
    THIRD_PLACE(new WinningCondition(5, false), BigDecimal.valueOf(1500000)),
    FOURTH_PLACE(new WinningCondition(4, false), BigDecimal.valueOf(50000)),
    FIFTH_PLACE(new WinningCondition(3, false), BigDecimal.valueOf(5000));

    private WinningCondition winningCondition;
    private BigDecimal prizeAmount;

    LottoWinTable(WinningCondition winningCondition, BigDecimal prizeAmount) {
        this.winningCondition = winningCondition;
        this.prizeAmount = prizeAmount;
    }

    public static Optional<LottoWinTable> find(WinningCondition condition) {
        return stream(LottoWinTable.values())
                .filter(lottoWinTable -> lottoWinTable.checkWinningCondition(condition))
                .findFirst();
    }

    private boolean checkWinningCondition(WinningCondition condition) {
        return winningCondition.equals(condition);
    }

    public BigDecimal getPrizeAmount() {
        return prizeAmount;
    }
}
