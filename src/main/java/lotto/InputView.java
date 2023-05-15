package lotto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int priceView() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = scanner.nextLine();
        return Integer.parseInt(price);
    }

    public String winnerNumbersView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String bonusNumbersView() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

}
