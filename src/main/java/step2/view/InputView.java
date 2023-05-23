package step2.view;

import java.util.Scanner;

public class InputView {


    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
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

    public static String[] readManualTicketNumbers() {
        return splitByDelimiter(readString());
    }

    public static String[] readWinningNumbers() {
        return splitByDelimiter(readString());
    }

    private static String[] splitByDelimiter(String expression) {
        return expression.trim().split(DELIMITER);
    }

    private static String readString() {
        return scanner.nextLine();
    }

    public static int readCountOfManualTicket() {
        return readInt("수동으로 구매할 로또 수를 입력해 주세요.");
    }
}
