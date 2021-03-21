package step2.View;

import java.util.Scanner;

public class InputView {
    public int getMoneyInput() {
        System.out.println("구입금액을 입력해주세요");
        return new Scanner(System.in).nextInt();
    }

    public String getLastWeekWiningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return new Scanner(System.in).nextLine();
    }
}
