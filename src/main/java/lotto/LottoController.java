package lotto;

import java.util.Scanner;

public class LottoController {
    public static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    public static final String PRIZE_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public void start() {

        InputView inputView = new InputView(askNumberOfPurchase());

        Lotto lotto = new Lotto(inputView.getLottoCount());
        InputResult inputResult = new InputResult(lotto);
        inputResult.showResult();

        ResultView resultView = new ResultView(askLastPrizeNumber(), lotto);
        resultView.getWinLottos();
    }

    private int askNumberOfPurchase() {
        System.out.println(AMOUNT_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    private String askLastPrizeNumber() {
        System.out.println(PRIZE_QUESTION);
        return scanner.nextLine();
    }

}
