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

        OutputView outputView = new OutputView();
        outputView.printBuyList(buyLotto);

        String winLottoInputValue = inputView.askWinnerLottoNumber();

        int bonusBallInputValue = inputView.askBonusNumber();
        WinLotto winLotto = new WinLotto(winLottoInputValue, bonusBallInputValue);

        RankList rankList = controlLottoGame.setRanktList(winLotto, buyLotto);

        ResultInfo resultInfo = controlLottoGame.setResult(rankList);


        System.out.println(rankList);
    }
}
