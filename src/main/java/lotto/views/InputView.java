package lotto.views;

import java.util.Scanner;

import lotto.LottoProcessor;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println((purchaseAmount / LottoProcessor.AMOUNT) + "개를 구매했습니다.");
        return purchaseAmount;
    }

    public static String inputLastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputbonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
