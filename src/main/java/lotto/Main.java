package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            int purchaseAmount = InputView.readAmount();

            int manualLottoCount = InputView.readManualCount();
            List<List<Integer>> manualLottoNumbers = InputView.readManualNumbers(manualLottoCount);

            IssuedLottoTickets issuedLottoTickets = LottoTicketMachine.issue(purchaseAmount, manualLottoNumbers);
            ResultView.printLottoTickets(issuedLottoTickets);

            LottoTicket winLottoTicket = new LottoTicket(new LottoNumbers(InputView.readWinNumbers()));
            LottoNumber bonusNumber = LottoNumber.of(InputView.readBonusNumber());
            WinLotto winLotto = new WinLotto(winLottoTicket, bonusNumber);

            LottoStatistics statistics = new LottoStatistics(issuedLottoTickets, winLotto);

            ResultView.printLottoStatistics(statistics);
        } catch (IllegalArgumentException e) {
            ResultView.printException(e.getMessage());
        } catch (Exception e) {
            ResultView.printException("예기치 못한 예외가 발생했습니다.");
            e.printStackTrace();
        }

    }

}
