package lotto.core;

import lotto.domain.Money;
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

    public LottoTickets getTickets(Money amount) {
        int totalCount = amount.countOfTickets();
        outputView.printMessage(Message.REQUEST_MANUAL_LOTTO_TICKET_COUNT);

        boolean stopReceivingInput = false;
        int manualCount = 0;
        while (!stopReceivingInput) {
            manualCount = inputView.receiveIntegerInput();
            stopReceivingInput = checkTicketCount(totalCount, manualCount);
        }

        outputView.printMessage(Message.REQUEST_MANUAL_LOTTO_TICKETS);
        LottoTickets lottoTickets
                = new LottoTickets(requestTicketsInput(new ManualLottoTicketGenerator(), manualCount));
        lottoTickets.combineWith(requestTicketsInput(new AutoLottoTicketGenerator(), totalCount - manualCount));

        outputView.printMessage(Message.INFO_MANUAL_AUTO_COUNT, manualCount, totalCount - manualCount);
        outputView.printInfo(lottoTickets.toString());
        return lottoTickets;
    }

    private List<LottoTicket> requestTicketsInput(TicketGenerator generator, int count) {
        List<LottoTicket> tickets;
        try {
            tickets = generator.generate(count);
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return tickets;
    }

    private boolean checkTicketCount(int totalCount, int input) {
        if (totalCount < input) {
            outputView.printMessage(Message.ERROR_LOTTO_COUNT_OUT_OF_RANGE, totalCount);
            return false;
        }
        return true;
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

    public Money getPurchaseAmount() {
        outputView.printMessage(Message.REQUEST_INPUT_AMOUNT);
        Money money = null;
        while (money == null) {
            money = requestMoneyInput();
        }
        return money;
    }

    private Money requestMoneyInput() {
        Money money;
        try {
            money = new Money(inputView.receiveIntegerInput());
        } catch (Exception e) {
            outputView.printExceptionMessage(e);
            return null;
        }
        return money;
    }
}
