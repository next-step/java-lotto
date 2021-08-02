package edu.nextstep.lotto.step2.domain;

import java.util.function.BiFunction;

public enum WinningAmount {
    FOURTH(3, 5000L, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 3) * 5000L)),
    THIRD(4, 50000L, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 4) * 50000L)),
    SECOND(5, 1500000L, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 5) * 1500000L)),
    FIRST(6, 2000000000L, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 6) * 2000000000L));

    private final int count;
    private final long amount;
    private final BiFunction<LottoList, WinningList, Long> benefit;

    WinningAmount(int count, long amount, BiFunction<LottoList, WinningList, Long> benefit) {
        this.count = count;
        this.amount = amount;
        this.benefit = benefit;
    }

    public int getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }

    public BiFunction<LottoList, WinningList, Long> getBenefit() {
        return benefit;
    }
}
