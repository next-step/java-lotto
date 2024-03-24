package lotto.controller;

import lotto.domain.*;
import lotto.numberdrawer.ShuffledNumberDrawer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int totalLottoCount = inputView.totalLottoCount();
        int manualLottoCount = inputView.manualLottoCount(totalLottoCount);
        int autoLottoCount = totalLottoCount - manualLottoCount;

        LottoTicket manualLottoTicket = inputView.manualLottoTicket(manualLottoCount);
        LottoTicket autoLottoTicket = LottoMachine.createLottoNumbers(autoLottoCount, new ShuffledNumberDrawer());

        LottoTicket finalLottoTicket = manualLottoTicket.combine(autoLottoTicket);

        outputView.printLottoCount(manualLottoCount, autoLottoCount);
        outputView.printLottoNumbers(finalLottoTicket);

        LottoNumbers inputWinningNumber = inputView.lottoNumbersInput();
        WinningNumber winningNumber = inputView.getFinalWinningNumber(inputWinningNumber);

        LottoResult lottoResult = finalLottoTicket.computeLottoResult(winningNumber);
        outputView.printResult(lottoResult);
    }
}
