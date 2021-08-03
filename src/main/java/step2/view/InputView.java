package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_OF_MONEY = "구입금액을 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO = "지난 주 당첨 번호를 입력 해 주세요";

    public static int inputMoney() {
        System.out.println(NUMBER_OF_MONEY);
        return scanner.nextInt();
    }

    public static String inputWinOfLottoNumber() {
        System.out.println(NUMBER_OF_LOTTO);
        return scanner.next();
    }


}
