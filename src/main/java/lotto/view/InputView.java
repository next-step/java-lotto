package lotto.view;

import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int inputBuyPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public String inputWinningLottoNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        return scan.next();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return scan.nextInt();
    }

}
