import view.InputVIew;
import view.ResultView;
import vo.*;

public class LottoGame {
    public static void main(String[] args) {
        InputVIew inputView = new InputVIew();
        ResultView resultView = new ResultView();

        Money money = new Money(inputView.purchaseAmount());
        resultView.printPurchaseTicketCount(money.lotteryCount());

        Lottos lottos = LottoGenerator.generateByMoney(money);
        System.out.println(lottos);

        WinningLotto winningNumber = inputView.winningNumber();
        MatchingResults result = lottos.match(winningNumber);

        resultView.show(result);
    }
}
