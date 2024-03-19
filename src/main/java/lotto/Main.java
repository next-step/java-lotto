package lotto;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.exception.IllegalPurchaseAmountException;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.validator.InputValidator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            int purchaseAmount = InputView.readAmount();
            InputValidator.validatePurchaseAmount(purchaseAmount);

            LottoTickets lottoTickets = LottoTicketMachine.issue(purchaseAmount);
            ResultView.printLottoTickets(lottoTickets);

            List<Integer> winNumbers = InputView.readWinNumbers();
            LottoStatistics statisticsMap = new LottoStatistics(lottoTickets, new LottoTicket(winNumbers));

            ResultView.printLottoStatistics(statisticsMap, purchaseAmount);
        } catch (IllegalPurchaseAmountException e) {
            ResultView.printException(e);
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.");
            e.printStackTrace();
        }

    }

}
