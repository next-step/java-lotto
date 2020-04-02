package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoBonusBall {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyLottoTotalPrice = inputView.askTotalPrice();
        int manualLottoCount = inputView.askManualLottoCount();
        String[] manulaLottoNumbers = inputView.askManualLottoNumber(manualLottoCount);
        ControlLottoGame controlLottoGame = new ControlLottoGame();
        BuyInfo buyInfo = controlLottoGame.startLotto(buyLottoTotalPrice, manulaLottoNumbers);
        OutputView outputView = new OutputView(buyInfo);
        WinLotto winLotto = askWinLotto(inputView);
        Ranks ranks = controlLottoGame.makeRankListByBuyLotto(winLotto, buyInfo);
        ResultInfo resultInfo = new ResultInfo(ranks, buyLottoTotalPrice);
        outputView.printResult(resultInfo);
    }

    private static WinLotto askWinLotto(InputView inputView) {
        String winLottoInputValue = inputView.askWinnerLottoNumber();
        LottoNumber bonusBallInputValue = inputView.askBonusNumber();
        return new WinLotto(winLottoInputValue, bonusBallInputValue);
    }
}
