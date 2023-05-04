package step2;

import java.util.Scanner;
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

        int money = getMoney(scanner, inputView);
        inputView.confirmComment(money);

        int manualLottoCount = getManualLottoCount(scanner, inputView);
        PurchasedLotto purchasedLottoList = LottoFactory.of(money, manualLottoCount);

        LottoView lottoView = new LottoView(purchasedLottoList);
        ResultView resultView = new ResultView(purchasedLottoList);

        lottoView.printLotto();

        String winningNumbers = getWinningNumbers(scanner, resultView);
        int bonusNumber = getBonusNumber(scanner, resultView);

        LottoService lottoService =
            new LottoService(
                new LotteryWin(new WinningNumbers(winningNumbers), bonusNumber),
                purchasedLottoList
            );

        lottoService.matchResult();

        resultView.printStatics();
        resultView.printProfit(money);
    }

    private static int getManualLottoCount(Scanner scanner, InputView inputView) {
        inputView.inputManualLottoCount();
        return scanner.nextInt();
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
        inputView.inputMoneyComment();
        return scanner.nextInt();
    }
}
