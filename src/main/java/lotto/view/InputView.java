package lotto.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(this.scanner.nextLine());
    }

    public String inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return this.scanner.nextLine();
    }
}
