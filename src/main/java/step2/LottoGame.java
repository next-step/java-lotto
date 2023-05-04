package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step2.domain.LotteryWin;
import step2.domain.LottoFactory;
import step2.domain.ManualLotto;
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
        int manualLottoCount = getManualLottoCount(scanner, inputView);

        inputView.inputManualLottoNumber();
        List<String> manualLottoList = getManualLottoList(scanner, manualLottoCount);

        ManualLotto manualLotto = new ManualLotto(manualLottoList);
        PurchasedLotto purchasedLottoList = LottoFactory.of(money, manualLottoCount);
        purchasedLottoList.addManualLottos(manualLotto);

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

    private static List<String> getManualLottoList(Scanner scanner, int manualLottoCount) {
        List<String> store = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            store.add(scanner.next());
        }
        return store;
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
