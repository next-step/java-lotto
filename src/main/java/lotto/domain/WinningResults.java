package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningResults {

    private final WinningLotto winningLotto;
    private final WinningReport winningReport;

    public WinningResults(LottoPaper lottoPaper, String winningNumberString, int bonusNumber) {
        this.winningLotto = new WinningLotto(initWinningNumber(winningNumberString), LottoNumber.of(bonusNumber));
        this.winningReport = lottoPaper.checkWinning(winningLotto);
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
