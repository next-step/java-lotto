package lotto.view;

import java.util.Scanner;

public class InputView {

    public String buyLottoView() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String winningLottoView() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String bonusNumberView() {
        System.out.println("보너스 보를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
