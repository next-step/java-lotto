package lotto;

import java.util.List;

public class LottoStore {

    public static void main(String[] args) {
        Report report = new Report(getDefaultWinningRules());

        Money money = UserInput.inputMoney();
        Orders orders = new Orders(money);
        report.reportTotalOrders(orders);

        Winners winners = UserInput.inputWinners();
        Statistics statistics = winners.match(orders);

        report.reportWinners(statistics);
        report.reportRateOfReturn(money, statistics);
    }

    private static WinningRules getDefaultWinningRules() {
        return new WinningRules(List.of(
                new WinningRule(3, 5000),
                new WinningRule(4, 50000),
                new WinningRule(5, 1500000),
                new WinningRule(6, 2000000000)
        ));
    }

}
