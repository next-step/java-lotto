package Lotto.view;

import java.util.Scanner;

public class InputView {

    private InputView() {}

    public static int inputBuyMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static String inputWinningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }

    public static int inputBonusLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
