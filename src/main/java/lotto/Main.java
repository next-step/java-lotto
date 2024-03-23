package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

    public static void main(String[] args) {

        try {
            int purchaseAmount = InputView.readAmount();

            LottoTickets lottoTickets = LottoTicketMachine.issue(purchaseAmount);
            ResultView.printLottoTickets(lottoTickets);

            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(InputView.readWinNumbers()));
            LottoNumber bonusNumber = LottoNumber.of(InputView.readBonusNumber());
            WinLotto winLotto = new WinLotto(winLottoTicket, bonusNumber);

            LottoStatistics statistics = new LottoStatistics(lottoTickets, winLotto);

            ResultView.printLottoStatistics(statistics);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e);
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.");
            e.printStackTrace();
        }

    }

}
