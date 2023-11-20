package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        buyLotto();

        //checkLottoResult();
    }

    public static List<Lotto> buyLotto() {
        int money = InputView.inputMoney();
        List<Lotto> tickets = LottoMachine.issue(money);
        ResultView.printCheckPurchaseMessage(tickets.size());
        return tickets;
    }
}
