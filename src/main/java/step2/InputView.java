package step2;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static InputView create() {
        return new InputView();
    }

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String getLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }
}
