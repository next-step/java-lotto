package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int buyAmount = InputView.inputBuyAmount();

        LottoService lottoService = new LottoService();

        int canBuyLottoCount = lottoService.canBuyLottoCount(buyAmount);
        LottoBuyer lottoBuyer = new LottoBuyer(canBuyLottoCount);
        ResultView.printCanBuyLottoCount(canBuyLottoCount);

        for (int count = 0; count < canBuyLottoCount; count++) {
            List<Integer> lotto = lottoService.buyLotto();
            lottoBuyer.saveLotto(count, lotto);
            ResultView.printLottoNumber(lotto);
        }

        String lastWeekWinningNumbers = InputView.inputLastWeekWinningNumbers();
        int[] winningStatics = lottoService.provideWinningStatics(lastWeekWinningNumbers, lottoBuyer.giveLottos());
        ResultView.printWinningStatics(winningStatics);

        float returnRate = lottoService.provideReturnRate(buyAmount, winningStatics);
        ResultView.printReturnRate(returnRate);
    }
}
