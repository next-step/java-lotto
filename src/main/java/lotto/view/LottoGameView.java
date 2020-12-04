package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.LottoGameResult;
import lotto.domain.Lottoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.view.InputView.ENTER_MANUAL_LOTTO_NUMBER;

public class LottoGameView {

    public static int enterLottoAmount() {
        return InputView.enterLottoAmount();
    }

    public static int enterManualLottoCount() {
        return InputView.enterManualLottoCount();
    }

    public static List<String> enterManualLottoNumber(LottoCount lottoCount) {
        return InputView.enterManualLottoNumber(lottoCount);
    }

    public static void printLottoNumbers(Lottoes lottoes) {
        ResultView.printLottoNumbers(lottoes);
    }

    public static void printResult(LottoGameResult lottoGameResult) {
        ResultView.printLottoGameResult(lottoGameResult.getRanks());
        ResultView.printWinningStatistics(lottoGameResult.getRateOfReturn());
    }

    public static String enterWinningNumbers() {
        return InputView.enterWinningNumbers();
    }

    public static int enterBonusNumber() {
        return InputView.enterBonusNumber();
    }
}
