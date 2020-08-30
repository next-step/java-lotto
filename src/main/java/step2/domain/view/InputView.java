package step2.domain.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputString();
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return inputString();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return inputString();
    }

    private String inputString() {
        return scanner.next();
    }
}
