package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {

    private final List<LottoNumber> winningNumbers;
    private final WinningReport winningReport;

    public WinningResults(String winningNumberString) {
        this.winningNumbers = initWinningNumber(winningNumberString);
        this.winningReport = new WinningReport();
    }

    private List<LottoNumber> initWinningNumber(String winningNumberString) {

        List<LottoNumber> winningNumbers = new ArrayList<>();

        String[] winningNumbersArray = winningNumberString.split(",");

        for (String winningNumber : winningNumbersArray) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(winningNumber.trim())));
        }

        return winningNumbers;
    }

    public void checkWinning(LottoPaper lottoPaper) {
        winningReport.checkWinning(lottoPaper, winningNumbers);
    }

    public WinningReport winningReport() {
        return winningReport;
    }

}
