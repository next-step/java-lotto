package view;

import java.util.Scanner;

public class InputView {

    public static String showExpressionInput() {
        System.out.println("수식 입력 > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Integer showLottoPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String showWinningLottoNumbersInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
