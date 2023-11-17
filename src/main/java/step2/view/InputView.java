package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PUT_PAY_PRICE = "구입금액을 입력해 주세요.";
    private static final String PUT_LAST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public int payPriceInput() {
        System.out.println(PUT_PAY_PRICE);
        return scanner.nextInt();
    }

    public String putLastWinNumbers() {
        scanner.nextLine();
        System.out.println(PUT_LAST_WIN_NUMBERS);
        return scanner.nextLine();
    }
}
