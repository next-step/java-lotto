package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ManualTicketGenerator;
import lotto.domain.SummaryReport;
import lotto.view.InputViewInterface;
import lotto.view.OutputViewInterface;

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

    private int getBonusNumber() {
        outputView.printPrompt(BONUS_NUMBERS_MSG);
        return inputView.getNumberInput();
    }

    private LottoTickets generateAllTickets() {
        outputView.printPrompt(PAID_MONEY_MSG);
        int paidMoney = inputView.getNumberInput();

        outputView.printPrompt(MANUAL_TICKET_COUNT_MSG);
        int manualCount = inputView.getNumberInput();

        LottoTickets lottoTickets = generateManualTickets(manualCount);
        LottoTickets autoTickets = LottoTickets.generate(paidMoney - (manualCount * LottoTicket.PRICE));
        lottoTickets.addAll(autoTickets);
        outputView.printTicketCount(manualCount, autoTickets.size());

        return lottoTickets;
    }

    private LottoTickets generateManualTickets(int count) {
        outputView.printPrompt(MANUAL_TICKET_NUMBERS_MSG);
        LottoTickets manualTickets = new LottoTickets();
        int i = 0;
        while (i < count) {
            int[] numbers = inputView.getNumberListInput(DELIMITER);
            LottoTicket ticket = createTicket(numbers);
            if (ticket == null) continue;
            manualTickets.add(ticket);
            i++;
        }
        return manualTickets;
    }

    private LottoTicket createTicket(int[] numbers) {
        try {
            return ManualTicketGenerator.generate(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    private LottoTicket getWinningTicket() {
        outputView.printPrompt(WINNING_LOTTERY_NUMBERS_MSG);
        int[] winningNumber = inputView.getNumberListInput(DELIMITER);
        return new LottoTicket(winningNumber);
    }
}
