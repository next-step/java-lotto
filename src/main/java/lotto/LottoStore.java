package lotto;

import lotto.domain.*;
import lotto.view.Report;
import lotto.view.UserInput;

public class LottoStore {

    public static void main(String[] args) {

        Money money = UserInput.inputMoney();
        Orders orders = new Orders(money);

        Report report = new Report(WinningRules.getDefaultWinningRules());
        report.reportTotalOrders(orders);

        Winners winners = UserInput.inputWinners();
        Statistics statistics = winners.match(orders);

        report.reportWinners(statistics);
        report.reportRateOfReturn(money, statistics);
    }
}
