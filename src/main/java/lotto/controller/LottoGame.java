package lotto.controller;

import lotto.domain.*;
import lotto.numberdrawer.ShuffledNumberDrawer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    public static void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int totalLottoCount = inputView.totalLottoCount();
        int manualLottoCount = inputView.manualLottoCount(totalLottoCount);
        int autoLottoCount = totalLottoCount - manualLottoCount;

        List<LottoNumbers> manualLottoTicket = inputView.manualLottoTicket(manualLottoCount);
        List<LottoNumbers> autoLottoTicket = LottoMachine.createLottoNumbers(autoLottoCount, new ShuffledNumberDrawer());

        LottoTicket finalLottoTicket = LottoTicket.from(manualLottoTicket, autoLottoTicket);

        outputView.printLottoCount(manualLottoCount, autoLottoCount);
        outputView.printLottoNumbers(finalLottoTicket);

        LottoNumbers inputWinningNumber = inputView.lottoNumbersInput();
        WinningNumber winningNumber = inputView.getFinalWinningNumber(inputWinningNumber);

        LottoResult lottoResult = finalLottoTicket.computeLottoResult(winningNumber);
        outputView.printResult(lottoResult);
    }
}
