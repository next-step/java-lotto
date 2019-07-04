package lotto.controller;

import lotto.model.LottoAllLine;
import lotto.model.LottoMachine;
import lotto.model.LottoOneLine;
import lotto.model.LottoPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] arg) {
        LottoPrice lottoPrice = new LottoPrice(InputView.inputLotteGames());
        int inputLottoManualCount = InputView.inputManualLottoCount();
        List<String> inputLottoManualNumbers = InputView.inputManualLottoNumbers(inputLottoManualCount);

        int lottoAutoCount = lottoPrice.lottoAutoCount(inputLottoManualCount);
        List<LottoOneLine> lottoOneLines = LottoMachine.extractLottoNumbers(lottoAutoCount);
        LottoMachine.manualLottoNumbers(lottoOneLines, inputLottoManualNumbers);

        OutputView.printGameCount(lottoAutoCount, inputLottoManualCount);
        OutputView.printPurchaseLottoNumber(lottoOneLines);

        String inputLastWeekLottoNumber = InputView.inputLastWeekLottoNumber();
        String inputLastWeekBonusNumber = InputView.inputLastWeekBonusNumber();
        LottoAllLine lottoAllLine = new LottoAllLine(lottoOneLines, inputLastWeekLottoNumber, inputLastWeekBonusNumber);

        OutputView.printWinnerSummary(lottoAllLine);
        OutputView.printRateOfReturn(lottoPrice.getLottoPrice());
    }

}
