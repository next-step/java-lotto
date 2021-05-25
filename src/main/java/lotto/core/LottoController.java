package lotto.core;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> winningNumbersCandidate = null;
        WinningNumbers winningNumbers = null;

        while (winningNumbersCandidate == null) {
            winningNumbersCandidate = requestWinningNumbersInput();
        }

        outputView.printMessage(Message.REQUEST_INPUT_BONUS_NUMBERS);
        while (winningNumbers == null) {
            winningNumbers = createWinningNumbersWith(winningNumbersCandidate, getBonusNumber());
        }
        return winningNumbers;
    }

    private WinningNumbers createWinningNumbersWith(List<Integer> numbers, Integer bonusNumber) {
        WinningNumbers winningNumbers;
        try {
            winningNumbers = new WinningNumbers(numbers, bonusNumber);
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return winningNumbers;
    }

    private List<Integer> requestWinningNumbersInput() {
        List<Integer> numbers;
        try {
            numbers = Arrays.asList(inputView.receiveIntegerArrayInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return numbers;
    }

    public void getLottoResult(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        outputView.printLottoResult(lottoTickets.matchingResultWith(winningNumbers));
    }

    private Integer getBonusNumber() {
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
