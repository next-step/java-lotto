package lotto.domain;

public class LottoWin {
    public static final String HEADER = "당첨통계\n---------\n";
    private final LottoWinNumber lottoWinNumber;
    private final LottoWinStatics lottoWinStatics;

    public LottoWin(LottoBuy lottoBuy, String winNumberString) {
        this.lottoWinNumber = new LottoWinNumber(winNumberString);
        this.lottoWinStatics = new LottoWinStatics(lottoBuy, lottoWinNumber);
    }

    @Override
    public String toString() {
        return HEADER + lottoWinStatics;
    }
}
