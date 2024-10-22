package lotto;

import lotto.application.AutoGenerator;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchasePrice = inputView.getPurchasePrice();

        int passiveLottoTicketCount = inputView.getPassiveLottoTicketCount();

        List<List<Integer>> passiveLottoNumbers = inputView.getPassiveLottoNumbers(passiveLottoTicketCount);

        Lotto lotto = new Lotto(new AutoGenerator());
        int lottoTicketCount = lotto.getLottoTicketCount(purchasePrice);
        resultView.print(lottoTicketCount + "개를 구매했습니다.");

        LottoTickets lottoTickets = lotto.issue(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        resultView.getResultAndPrint(lottoTickets, new WinningNumbers(winningNumbers, bonusNumber));
    }

}
