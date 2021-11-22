package lotto.view;

import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import java.util.Scanner;

public class Input {

    private static Scanner SCANNER = new Scanner(System.in);

    private static Integer PRICE_PER_LOTTO = 1000;

    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = SCANNER.nextInt();
        System.out.println(purchaseAmount / PRICE_PER_LOTTO + "개를 구매했습니다.");
        return purchaseAmount;
    }

    public static WinningNumbers inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return new WinningNumbers(SCANNER.nextLine());
    }

    public static Number inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Number(SCANNER.nextInt());
    }
}