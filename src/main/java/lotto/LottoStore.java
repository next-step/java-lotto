package lotto;

import java.util.List;

public class LottoStore {

    public static void main(String[] args) {
        Report report = new Report(WinningRules.getDefaultWinningRules());

        Money money = UserInput.inputMoney();
        Orders orders = new Orders(money);
        report.reportTotalOrders(orders);

        Winners winners = UserInput.inputWinners();
        Statistics statistics = winners.match(orders);

        report.reportWinners(statistics);
        report.reportRateOfReturn(money, statistics);
    }
}
