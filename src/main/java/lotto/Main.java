package lotto;

import lotto.io.OutputView;
import lotto.model.Lottery;
import lotto.model.LottoResult;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinnerNumber;
import static lotto.io.OutputView.viewLotto;
import static lotto.util.LottoResultProvider.getResult;
import static lotto.util.LottoTicketBox.buy;

public class Main {
    public static void main(String[] args) {
        List<Lottery> lotteries = buy(InputPurchaseAmount());
        viewLotto(lotteries);
        LottoResult lottoResult = getResult(lotteries, inputWinnerNumber());
        OutputView.viewResult(lottoResult);
        OutputView.viewEarningRate(lotteries, lottoResult);
    }
}
