package lottoauto.view;

import java.util.Scanner;

public class InputView {

    public int inputLottoBuyMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String result = scanner.nextLine();
        System.out.println("result "  + result);
        return result;
    }
}