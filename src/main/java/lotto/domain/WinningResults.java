package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningResults {

    private final Lotto winningNumbers;
    private final WinningReport winningReport;

    public WinningResults(LottoPaper lottoPaper, String winningNumberString) {
        this.winningNumbers = initWinningNumber(winningNumberString);
        this.winningReport = lottoPaper.checkWinning(winningNumbers);
    }

    private Lotto initWinningNumber(String winningNumberString) {

        List<LottoNumber> winningNumbers = new ArrayList<>();

        String[] winningNumbersArray = winningNumberString.split(",");

        for (String winningNumber : winningNumbersArray) {
            winningNumbers.add(LottoNumber.of(Integer.parseInt(winningNumber.trim())));
        }

        return new Lotto(new HashSet<>(winningNumbers));
    }

    public WinningReport winningReport() {
        return winningReport;
    }

}
