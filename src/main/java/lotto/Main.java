package lotto;

import lotto.io.OutputView;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

import static lotto.io.InputView.InputPurchaseAmount;
import static lotto.io.InputView.inputWinnerNumber;
import static lotto.io.OutputView.viewLotto;
import static lotto.util.LottoResultProvider.getResult;
import static lotto.util.LottoTicketBox.buy;

public class Main {
    public static void main(String[] args) {
        List<Lotto> lottos = buy(InputPurchaseAmount());
        viewLotto(lottos);
        LottoResult lottoResult = getResult(lottos, inputWinnerNumber());
        OutputView.viewResult(lottoResult);
        OutputView.viewEarningRate(lottos, lottoResult);
    }
}
