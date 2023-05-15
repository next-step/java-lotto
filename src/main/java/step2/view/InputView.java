package step2.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int readAmountOfPurchase() {
        return readInt("구매 금액을 입력해 주세요");
    }

    public static int readBonusNumber() {
        return readInt("보너스 볼을 입력해 주세요.");
    }

    private static int readInt(String message) {
        System.out.println(message);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String nextLine) {
        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nextLine + " : 유효한 정수 값이 아닙니다.");
        }
    }

    public static String readWinningNumbers() {
        return readString("지난 주 당첨 번호를 입력해 주세요");
    }

    private static String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
