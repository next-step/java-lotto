package lotto;

import lotto.io.InputView;
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
        int money = InputPurchaseAmount();
        Lotteries lotteries = buy(money);

        viewLotto(lotteries);

        LottoResult lottoResult = new LottoResult(lotteries, inputWinnerNumber(), InputView.inputBonusBall());

        List<Rank> resultRank = lottoResult.getRank();

        OutputView.viewResult(resultRank);
        OutputView.viewEarningRate(money, resultRank);
    }
}
