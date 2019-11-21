package step3.view;

import java.util.Scanner;

public class InputView {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }

    public String inputResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public String inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
