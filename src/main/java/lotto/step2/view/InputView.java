package lotto.step2.view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String printInputOrderPrice() {
        System.out.println("구매 금액을 입력해주세요");
        return sc.nextLine();
    }

    public static String printInputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = sc.nextLine();
        System.out.println();
        return winningNumber;
    }

}
