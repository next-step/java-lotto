package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {

    }

    public static int inputAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    public static String inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }
}
