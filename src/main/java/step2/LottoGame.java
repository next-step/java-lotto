package step2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import step2.domain.LotteryWin;
import step2.domain.Lotto;
import step2.domain.LottoFactory;
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

        List<Lotto> lottoList = LottoFactory.of(money);

        lottoView.printLotto(lottoList);

        String winningNumbers = getWinningNumbers(scanner, resultView);

        LottoService lottoService = new LottoService(
            new LotteryWin(new WinningNumbers(winningNumbers))
        );

        Map<Integer, Integer> match = lottoService.match(lottoList);
        resultView.printStatics(match);

        String profitRate = lottoService.getProfitRate(money);
        resultView.printProfit(profitRate);
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
