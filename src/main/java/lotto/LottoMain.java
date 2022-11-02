package lotto;

import lotto.domain.Lotto;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        int manualLottoCount = InputView.inputManualLottoCount();

        Lotto.convertAmountToAutoTicketCount(amount, manualLottoCount, true);

        List<Ticket> manualTicketList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            ResultView.printManualLottoInputGuide(i);
            List<Integer> numbers = InputView.inputLottoNumber();
            manualTicketList.add(Ticket.of(numbers));
        }


        Lotto lotto = new Lotto(amount, manualTicketList, true);
        ResultView.printTicketCount(manualLottoCount, lotto.getTicketCount() - manualLottoCount);
        ResultView.printTickeList(lotto.getTicketList());

        List<Integer> winningNumbers = InputView.inputWinnigNumber();
        int bonusNumber = InputView.inputBonusNumber();
        Ticket lottoWinningTicket = Ticket.of(winningNumbers);
        WinningTicket winningTicket = new WinningTicket(lottoWinningTicket, bonusNumber);
        Ranks ranks = lotto.rankedWinningNumbers(winningTicket);

        ResultView.printLottoResult(ranks);
        ResultView.printIncomePercentage(ranks.caculateIncomePercentage());
    }
}
