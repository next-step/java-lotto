package lotto;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Money money = new Money(inputView.purchaseAmount());
        resultView.printPurchaseTicketCount(money.lotteryCount());

        Lottos lottos = LottoGenerator.generateByMoney(money);
        System.out.println(lottos);

        WinningLotto winningLotto = inputView.winningNumber();
    }
}
