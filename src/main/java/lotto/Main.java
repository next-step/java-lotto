package lotto;


import lotto.domain.*;


import static lotto.domain.LottoResult.*;
import static lotto.view.InputView.*;
import static lotto.view.InputView.inputBuyPrice;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {
        printStart();
        LottoPrice lottoPrice = inputBuyPrice();
        printLottoCount(lottoPrice);

        BuyLotto buyLotto = LottoMachine.createLotto(lottoPrice);
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
