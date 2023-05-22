package step2;

import step2.domain.*;
import step2.domain.Lotto.Lotto;
import step2.domain.Lotto.WinningLotto;
import step2.domain.winning.Winnings;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();

        resultView.start();
        Amount amount = new Amount(inputView.nextAmount());
        List<Lotto> lottos = Store.buyLotto(amount);
        resultView.purchaseHistory(lottos);

        resultView.lastWeeksWinningNum();
        WinningLotto winningLotto = new WinningLotto(inputView.nextLottoNum());
        List<Rank> ranks = lottos.stream()
                .map(lotto -> lotto.getRank(winningLotto.getWinningLottoNums()))
                .collect(Collectors.toList());

        Winnings winnings = new Winnings();
        for (Rank rank : ranks) {
            winnings.inquiry(rank);
        }

        resultView.result(winnings);
        resultView.rate(winnings.rate(amount));
    }
}
