package lotto;


import lotto.domain.*;


import static lotto.domain.LottoResult.*;
import static lotto.view.InputView.*;
import static lotto.view.InputView.inputBuyPrice;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {
        printStart();
        int price = inputBuyPrice();

        printPassiveBuyLottoCount();
        int passiveCount = inputPassiveBuyLottoCount();
        LottoPrice lottoPrice = new LottoPrice(price, passiveCount);

        BuyLotto buyLotto = new BuyLotto();
        if (passiveCount > 0) {
            printPassiveBuyLotto();
            inputPassiveBuyLotto(buyLotto, passiveCount);
        }

        printLottoCount(lottoPrice);

        LottoMachine.createLotto(buyLotto, lottoPrice);
        printBuyLotto(buyLotto);

        printResultLottoNumber();
        Lotto resultLotto = inputResultLottoNumber();
        printBonusNumber();
        int bonusNumber = inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(resultLotto, bonusNumber);

        printResultMessage();
        LottoResult lottoResult = winningLotto.checkLottoNumber(buyLotto);

        printResult(lottoResult);
        printProfit(profitPercent(lottoPrice));
    }
}
