package lotto.core;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public LottoTickets getTickets() {
        outputView.printMessage(Message.REQUEST_INPUT_AMOUNT);
        LottoTickets lottoTickets = null;
        while (lottoTickets == null) {
            lottoTickets = requestLottoTicketsInput();
        }
        outputView.printMessage(Message.INFO_TOTAL_COUNT, lottoTickets.count());
        outputView.printInfo(lottoTickets.toString());
        return lottoTickets;
    }

    private LottoTickets requestLottoTicketsInput() {
        LottoTickets lottoTickets;
        try {
            lottoTickets = new LottoTickets(LottoTicketGenerator.start(), inputView.receiveIntegerInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return lottoTickets;
    }

    public WinningNumbers getWinningNumbers() {
        outputView.printMessage(Message.REQUEST_INPUT_WINNING_NUMBERS);
        WinningNumbers winningNumbers = null;
        while (winningNumbers == null) {
            winningNumbers = requestWinningNumbersInput();
        }
        return winningNumbers;
    }

    private WinningNumbers requestWinningNumbersInput() {
        int[] numbers;
        try {
            numbers = inputView.receiveIntegerArrayInput();
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }

        WinningNumbers winningNumbers;
        try {
            winningNumbers = new WinningNumbers(numbers, getBonusNumber());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return winningNumbers;
    }

    public void getLottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        outputView.printLottoResult(lottoTickets.matchingResultWith(winningNumbers));
    }

    private Integer getBonusNumber() {
        outputView.printMessage(Message.REQUEST_INPUT_BONUS_NUMBERS);
        Integer lottoNumber = null;
        while (lottoNumber == null) {
            lottoNumber = requestBonusNumberInput();
        }
        return lottoNumber;
    }

    private Integer requestBonusNumberInput() {
        int bonusNumber;
        try {
            bonusNumber = inputView.receiveIntegerInput();
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return bonusNumber;
    }
}
