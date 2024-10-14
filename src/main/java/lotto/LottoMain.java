package lotto;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoTickets;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchasePrice = inputView.getPurchasePrice();

        Lotto lotto = new Lotto();
        int lottoTicketCount = lotto.getLottoTicketCount(purchasePrice);
        resultView.print(lottoTicketCount + "개를 구매했습니다.");

        LottoTickets lottoTickets = lotto.issue(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets);

        String[] winningNumbers = StringUtils.splitByComma(inputView.getWinningNumbers());
        resultView.getResultAndPrint(lottoTickets, winningNumbers);
    }

}
