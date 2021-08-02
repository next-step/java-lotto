package edu.nextstep.lotto.step2.domain;

import java.util.function.BiFunction;

public enum WinningAmount {
    FOURTH(3, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 3) * 5000L)),
    THIRD(4, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 4) * 50000L)),
    SECOND(5, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 5) * 1500000L)),
    FIRST(6, ((lottoList, winningList) -> lottoList.getMatchResult(winningList, 6) * 2000000000L));

    private final int count;
    private final BiFunction<LottoList, WinningList, Long> benefit;

    WinningAmount(int count, BiFunction<LottoList, WinningList, Long> benefit) {
        this.count = count;
        this.benefit = benefit;
    }

    public int getCount() {
        return count;
    }

    public BiFunction<LottoList, WinningList, Long> getBenefit() {
        return benefit;
    }
}
