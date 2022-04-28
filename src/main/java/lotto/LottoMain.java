package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.WinnerLottos;
import lotto.model.Lottos;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        int buyingMoney = InputView.inputBuyingMoney();
        List<Lottos> buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        ResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = InputView.inputWinnerLottoNumbers();
        Lottos winnerLottos = new WinnerLottos(winnerLottoNumbers).getLottos();

        Map<Integer, Integer> lottoStatistics = LottoMarket.getLottoStatistics(buyingLottos, winnerLottos);
    }
}
