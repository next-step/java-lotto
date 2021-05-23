package lotto.core;

import lotto.domain.LottoTickets;
import lotto.domain.Message;
import lotto.domain.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public LottoTickets getTickets() {
        outputView.printMessage(Message.REQUEST_INPUT_AMOUNT);
        boolean stopRequestingInput = false;
        while (!stopRequestingInput) {
            stopRequestingInput = requestLottoTicketsInput();
        }
        outputView.printMessage(Message.INFO_TOTAL_COUNT, lottoTickets.count());
        outputView.printInfo(lottoTickets.toString());
        return lottoTickets;
    }

    private boolean requestLottoTicketsInput() {
        boolean stopRequestingInput = true;
        try {
            lottoTickets = new LottoTickets(inputView.receivePurchaseAmount());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            stopRequestingInput = false;
        }
        return stopRequestingInput;
    }

    public WinningNumbers getWinningNumbers() {
        outputView.printMessage(Message.REQUEST_INPUT_WINNING_NUMBERS);
        boolean stopRequestingInput = false;
        while (!stopRequestingInput) {
            stopRequestingInput = requestWinningNumbersInput();
        }
        return winningNumbers;
    }

    private boolean requestWinningNumbersInput() {
        boolean stopRequestingInput = true;
        try {
            winningNumbers = new WinningNumbers(inputView.receiveWinningNumbers());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            stopRequestingInput = false;
        }
        return stopRequestingInput;
    }

    public void getLottoResult() {
        outputView.printLottoResult(lottoTickets.matchingResultWith(winningNumbers));
    }
}
