package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoBonusBall {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyLottoTotalPrice = inputView.askTotalPrice();

        ControlLottoGame controlLottoGame = new ControlLottoGame();
        BuyLotto buyLotto = controlLottoGame.startLotto(buyLottoTotalPrice);

        OutputView outputView = new OutputView(buyLotto);

        WinLotto winLotto = askWinLotto(inputView);

        RankList rankList = controlLottoGame.makeRankListByBuyLotto(winLotto, buyLotto);

        ResultInfo resultInfo = new ResultInfo(buyLottoTotalPrice);
        controlLottoGame.setResult(resultInfo, rankList);
        outputView.printResult(resultInfo, rankList);
    }

    private static WinLotto askWinLotto(InputView inputView) {
        String winLottoInputValue = inputView.askWinnerLottoNumber();
        LottoNumber bonusBallInputValue = inputView.askBonusNumber();
        return new WinLotto(winLottoInputValue, bonusBallInputValue);
    }
}
