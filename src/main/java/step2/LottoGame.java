package step2;

import java.util.Scanner;
import step2.domain.BonusNumber;
import step2.domain.LotteryWin;
import step2.domain.LottoFactory;
import step2.domain.PurchasedLotto;
import step2.domain.WinningNumbers;
import step2.service.LottoService;
import step2.view.InputView;
import step2.view.LottoView;
import step2.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        LottoView lottoView = new LottoView();
        ResultView resultView = new ResultView();

        int money = getMoney(scanner, inputView);
        inputView.confirmComment(money);

        PurchasedLotto purchasedLottoList = LottoFactory.of(money);

        lottoView.printLotto(purchasedLottoList.get());

        String winningNumbers = getWinningNumbers(scanner, resultView);
        int bonusNumber = getBonusNumber(scanner, resultView);

        LottoService lottoService = new LottoService(
            new LotteryWin(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber))
        );

        lottoService.matchResult(purchasedLottoList);
        resultView.printStatics(purchasedLottoList);


        String profitRate =
            lottoService.getProfitRate(money, purchasedLottoList.getSumOfWinningMoney());
        resultView.printProfit(profitRate);
    }

    private static int getBonusNumber(Scanner scanner, ResultView resultView) {
        resultView.bonusNumberComment();
        return scanner.nextInt();
    }

    private static String getWinningNumbers(Scanner scanner, ResultView resultView) {
        resultView.winningNumberComment();
        return scanner.next();
    }

    private static int getMoney(Scanner scanner, InputView inputView) {
        inputView.inputComment();
        return scanner.nextInt();
    }
}
