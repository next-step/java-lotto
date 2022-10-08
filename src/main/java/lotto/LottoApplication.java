package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApplication {
    public static void main(String[] args) {
        Lottos lottos = new Lottos(inputPurchaseNumber());
        printPurchaseNumber(lottos.lottosSize());
        printLottoNumbers(lottos);

        printWinningResult(lottos.getResult(new Lotto(inputWinningNumber())));
        printProfitRate(lottos);
    }
}
