package lotto.controller;

import lotto.domain.*;
import lotto.view.InputViewInterface;
import lotto.view.OutputViewInterface;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final String PAID_MONEY_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTERY_NUMBERS_MSG = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBERS_MSG = "보너스 볼을 입력해 주세요.";
    public static final String MANUAL_TICKET_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_TICKET_NUMBERS_MSG = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String DELIMITER = ",";

    private final InputViewInterface inputView;
    private final OutputViewInterface outputView;

    public LottoMachine(InputViewInterface inputView, OutputViewInterface outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoTickets lottoTickets = generateAllTickets();
        outputView.printTickets(lottoTickets);

        LottoTicket winningTicket = getWinningTicket();
        int bonusNumber = getBonusNumber();

        SummaryReport summaryReport = lottoTickets.getSummary(winningTicket, bonusNumber);
        outputView.printSummary(summaryReport);
    }

    private LottoTickets generateAllTickets() {
        outputView.printPrompt(PAID_MONEY_MSG);
        int paidMoney = inputView.getNumberInput();

        outputView.printPrompt(MANUAL_TICKET_COUNT_MSG);
        int manualCount = inputView.getNumberInput();
        List<int[]> manualNumbers = getManualNumbers(manualCount);

        int autoCount = (paidMoney - (manualCount * LottoTicket.PRICE)) / LottoTicket.PRICE;
        LottoTickets lottoTickets = LottoTickets.generate(manualNumbers, autoCount);
        outputView.printTicketCount(manualCount, autoCount);

        return lottoTickets;
    }

    private List<int[]> getManualNumbers(int count) {
        outputView.printPrompt(MANUAL_TICKET_NUMBERS_MSG);
        List<int[]> manualNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualNumbers.add(inputView.getNumberListInput(DELIMITER));
        }
        return manualNumbers;
    }

    private LottoTicket getWinningTicket() {
        outputView.printPrompt(WINNING_LOTTERY_NUMBERS_MSG);
        int[] winningNumber = inputView.getNumberListInput(DELIMITER);
        return new LottoTicket(winningNumber);
    }

    private int getBonusNumber() {
        outputView.printPrompt(BONUS_NUMBERS_MSG);
        return inputView.getNumberInput();
    }
}
