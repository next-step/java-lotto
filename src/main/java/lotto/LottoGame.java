package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        Store store = new Store(InputView.getMoney());
        List<LottoTicket> lottoTickets = store.getLottoTickets();

        ResultView.viewCountOfLotto(lottoTickets.size());
        ResultView.viewLottoTickets(lottoTickets);

        InputView.getWinningNumbers();
    }
}
