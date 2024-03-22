package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            int purchaseAmount = InputView.readAmount();

            LottoTickets lottoTickets = LottoTicketMachine.issue(purchaseAmount);
            ResultView.printLottoTickets(lottoTickets);

            List<Integer> winNumbers = InputView.readWinNumbers();
            int bonusNumber = InputView.readBonusNumber();

            LottoStatistics statisticsMap = new LottoStatistics(lottoTickets, new LottoTicket(winNumbers), new LottoNumber(bonusNumber));

            ResultView.printLottoStatistics(statisticsMap, purchaseAmount);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e);
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.");
            e.printStackTrace();
        }

    }

}
