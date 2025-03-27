package lotto.controller;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketList;
import lotto.domain.SummaryReport;
import lotto.view.InputViewInterface;
import lotto.view.ResultViewInterface;

public class LottoMachine {
    public static final String PAID_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    public static final String WINNING_LOTTERY_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.\n";
    public static final String BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.\n";

    private final InputViewInterface inputView;
    private final ResultViewInterface resultView;

    public LottoMachine(InputViewInterface inputView, ResultViewInterface resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int paidMoney = inputView.getNumberInput(PAID_MONEY_MESSAGE);
        LottoTicketList lottoTickets = LottoTicketList.generate(paidMoney, new LottoNumberGenerator());
        resultView.printTickets(lottoTickets);

        String[] winningNumber = inputView.getStringListInput(WINNING_LOTTERY_NUMBERS_MESSAGE, ",");
        LottoTicket winningTicket = new LottoTicket(winningNumber);

        int bonusNumber = inputView.getNumberInput(BONUS_NUMBERS_MESSAGE);

        SummaryReport summaryReport = lottoTickets.getSummary(winningTicket, bonusNumber);

        resultView.printSummary(summaryReport);
    }
}
