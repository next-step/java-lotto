package edu.nextstep.lottoauto;

public enum WinningPrize {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 200_000_000);

    WinningPrize(int numberOFMatching, int winningPrize) {
    }
}
