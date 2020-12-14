package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(money);

        LottoShop lottoShop = LottoShop.getInstance();
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(money);

        OutputView.printLottoTicketCount(lottoTicketCount.getLottoTicketCount());
        OutputView.printLottoNumbers(publishedLottoTicket.getPublishedLottoTicket());

        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();

    }

}
