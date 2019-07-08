package lotto;

import lotto.io.OutputView;
import lotto.model.Lotteries;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinnerNumber;
import static lotto.io.OutputView.viewLotto;
import static lotto.util.LottoTicketBox.buy;

public class Main {
    public static void main(String[] args) {
        Lotteries lotteries = buy(InputPurchaseAmount());
        viewLotto(lotteries);
        LottoResult lottoResult = new LottoResult(lotteries, inputWinnerNumber());
        List<Rank> ranks = lottoResult.getRank();
        ranks.forEach(e -> System.out.println(e.getCountOfMatch()));
//        OutputView.viewResult(lottoResult);
//        OutputView.viewEarningRate(lotteries, lottoResult);
    }
}
