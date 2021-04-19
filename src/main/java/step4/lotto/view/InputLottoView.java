package step4.lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputLottoView {
    public int inputMoney() throws InputMismatchException {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }
}
