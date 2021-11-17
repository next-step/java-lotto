package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String NUMBER_TYPE_ERROR_MESSAGE = "error : 아라비아 숫자만 입력할수 있습니다.";
    private static final String LAST_WEEK_LOTTERY_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요. (번호는 ',' 로 구분)";

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);

        return validNumber();
    }

    public static String inputLastWeekNumber() {
        System.out.println(LAST_WEEK_LOTTERY_NUMBER_MESSAGE);

        return scanner.nextLine();
    }

    private static int validNumber() {
        if (!scanner.hasNextInt()) {
            throw new IllegalArgumentException(NUMBER_TYPE_ERROR_MESSAGE);
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }

}
