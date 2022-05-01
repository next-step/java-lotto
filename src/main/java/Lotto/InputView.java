package Lotto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputBuyMoney() {
        System.out.println("구매금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static String inputLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.next();
    }
}
