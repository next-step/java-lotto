package lotto;

import java.util.Scanner;

public class LottoController {
    public static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        InputView inputView = new InputView(askNumberOfPurchase());
        Lotto lotto = new Lotto(inputView.getLottoCount());
        InputResult inputResult = new InputResult(lotto);
        System.out.println(inputResult.showResult());
    }


    private int askNumberOfPurchase() {
        System.out.println(AMOUNT_QUESTION);
        return scanner.nextInt();
    }

}
