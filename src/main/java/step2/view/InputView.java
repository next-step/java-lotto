package step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCash() {
        System.out.println(INPUT_CASH_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputLastWeekLottoNumber() {
        System.out.println(INPUT_LAST_WEEK_LOTTO_NUMBER_MESSAGE);
        scanner.nextLine();//버퍼 비우기
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
