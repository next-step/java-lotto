package lotto;

import lotto.io.InputView;
import lotto.io.OutputView;
import lotto.model.Lotteries;
import lotto.model.LottoResult;
import lotto.model.Rank;
import lotto.model.WinningNumber;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinningNumbers;
import static lotto.io.OutputView.viewLotto;
import static lotto.util.LottoTicketBox.buy;

public class Main {
    public static void main(String[] args) {
        int money = InputPurchaseAmount();
        Lotteries lotteries = buy(money);

        viewLotto(lotteries);

        WinningNumber winningNumber = new WinningNumber(inputWinningNumbers(), InputView.inputBonusBall());

        LottoResult lottoResult = new LottoResult(lotteries, winningNumber);

        List<Rank> resultRank = lottoResult.getRank();

        OutputView.viewResult(resultRank);
        OutputView.viewEarningRate(money, resultRank);
    }
}
