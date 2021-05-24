package lotto.core;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void getTickets() {
        outputView.printMessage(Message.REQUEST_INPUT_AMOUNT);
        boolean stopRequestingInput = false;
        while (!stopRequestingInput) {
            stopRequestingInput = requestLottoTicketsInput();
        }
        outputView.printMessage(Message.INFO_TOTAL_COUNT, lottoTickets.count());
        outputView.printInfo(lottoTickets.toString());
    }

    private boolean requestLottoTicketsInput() {
        boolean stopRequestingInput = true;
        try {
            lottoTickets = new LottoTickets(LottoTicketGenerator.start(), inputView.receiveIntegerInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            stopRequestingInput = false;
        }
        return stopRequestingInput;
    }

    public void getWinningNumbers() {
        outputView.printMessage(Message.REQUEST_INPUT_WINNING_NUMBERS);
        boolean stopRequestingInput = false;
        while (!stopRequestingInput) {
            stopRequestingInput = requestWinningNumbersInput();
        }
    }

    private boolean requestWinningNumbersInput() {
        boolean stopRequestingInput = true;
        try {
            winningNumbers = new WinningNumbers(inputView.receiveIntegerArrayInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            stopRequestingInput = false;
        }
        return stopRequestingInput;
    }

    public void getLottoResult() {
        outputView.printLottoResult(lottoTickets.matchingResultWith(winningNumbers));
    }

    public void getBonusNumber() {
        outputView.printMessage(Message.REQUEST_INPUT_BONUS_NUMBERS);
        boolean stopRequestingInput = false;
        while (!stopRequestingInput) {
            stopRequestingInput = requestBonusNumberInput() && winningNumbers.addBonusNumber(bonusNumber);
        }
    }

    private boolean requestBonusNumberInput() {
        boolean stopRequestingInput = true;
        try {
            bonusNumber = new BonusNumber(inputView.receiveIntegerInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            stopRequestingInput = false;
        }
        return stopRequestingInput;
    }
}
