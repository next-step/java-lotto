package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

public class LottoBonusBall {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int buyLottoTotalPrice = inputView.askTotalPrice();

        ControlLottoGame controlLottoGame = new ControlLottoGame();
        BuyLotto buyLotto = controlLottoGame.startLotto(buyLottoTotalPrice);

        OutputView outputView = new OutputView();
        outputView.printBuyList(buyLotto);

        String winLottoInputValue = inputView.askWinnerLottoNumber();
        WinLotto winLotto = new WinLotto(winLottoInputValue);

        int bonusBallInputValue = inputView.askBonusNumber();
        BonusBall bonusBall = new BonusBall(bonusBallInputValue);
    }
}
