package lotto.view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPurchaseAmount = SCANNER.nextInt();
        SCANNER.skip("\n");
        return lottoPurchaseAmount;
    }

    public static String inputWinningLottoNumbersString() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}