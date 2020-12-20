package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String lastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.skip("\\R").nextLine();
    }
}
