package lotto;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final String PAID_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    public static final String WINNING_LOTTERY_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.\n";

    public static void main(String[] args) {
        int paidMoney = InputView.getNumberInput(PAID_MONEY_MESSAGE);
        List<LottoTicket> lottoTickets = LottoGenerator.generate(paidMoney);
        ResultView.printTickets(lottoTickets);

        String[] winningNumber = InputView.getStringListInput(WINNING_LOTTERY_NUMBERS_MESSAGE, ",");
        LottoTicket winningTicket = new LottoTicket(winningNumber);

        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            results.add(ticket.matchWinner(winningTicket));
        }

        ResultView.printSummary(LottoChecker.getSummary(results));
    }
}
