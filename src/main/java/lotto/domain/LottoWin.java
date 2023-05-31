package lotto.domain;

public class LottoWin {
    public static final String HEADER = "당첨통계\n---------\n";
    private final LottoWinNumber lottoWinNumber;
    private final LottoWinStatistics lottoWinStatistics;

    public LottoWin(LottoBuy lottoBuy, String winNumberString) {
        this.lottoWinNumber = new LottoWinNumber(winNumberString);
        this.lottoWinStatistics = new LottoWinStatistics(lottoBuy, lottoWinNumber);
    }

    @Override
    public String toString() {
        return HEADER + lottoWinStatistics;
    }
}
