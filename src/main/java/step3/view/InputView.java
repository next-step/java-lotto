package step3.view;

import step2.domain.LottoNumber;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static int inputMessageLottoAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputMessageLastWeekWinningNumber() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public static int inputMessageBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해주세요");
        return scanner.nextInt();
    }
}
