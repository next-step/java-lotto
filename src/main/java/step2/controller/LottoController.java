package step2.controller;

import step2.domain.Lotto;
import step2.domain.LottoMachine;
import step2.domain.Person;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {
    public void start() {
        ResultView.printPurchasePrice();
        int purchasePrice = InputView.inputPurchasePrice();

        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> buyLottoList = lottoMachine.buyLotto(purchasePrice);

        int purchaseLottoCount = buyLottoList.size();
        ResultView.printPurchaseCount(purchaseLottoCount);

        Person person = new Person();

        ResultView.printWinNumber();
        int[] winNumber = InputView.inputWinNumber();
        int[][] winCounts = person.getWin(winNumber, buyLottoList);
        ResultView.printWinCounts(winCounts);

        double totalRevenue = person.getTotalRevenue(purchasePrice, winCounts);
        ResultView.printTotalRevenue(totalRevenue);
    }
}
