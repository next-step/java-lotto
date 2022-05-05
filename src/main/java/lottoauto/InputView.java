package lottoauto;

import java.util.Scanner;

public class InputView {
    public static final String LOTTO_NUMBER_DELIMITER = ", ";

    private InputView() {}

    public static int inputPurchaseAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static String[] inputWinningNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine().split(LOTTO_NUMBER_DELIMITER);
    }
}
