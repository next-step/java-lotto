package com.hskim.lotto.model;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Arrays.stream;

public enum LottoWinTable {

    FIRST_PLACE(new WinningCondition(6), "6개 일치", BigDecimal.valueOf(2000000000)),
    SECOND_PLACE(new WinningCondition(5), "5개 일치", BigDecimal.valueOf(15000000)),
    THIRD_PLACE(new WinningCondition(4), "4개 일치", BigDecimal.valueOf(50000)),
    FOURTH_PLACE(new WinningCondition(3), "3개 일치", BigDecimal.valueOf(5000));

    private WinningCondition winningCondition;
    private String message;
    private BigDecimal prizeAmount;

    LottoWinTable(WinningCondition winningCondition, String message, BigDecimal prizeAmount) {
        this.winningCondition = winningCondition;
        this.message = message;
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
}