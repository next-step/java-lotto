package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int buyingMoney = InputView.inputBuyingMoney();
        List<Lottos> buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());
        ResultView.printBuyingLottos(buyingLottos);
    }
}
