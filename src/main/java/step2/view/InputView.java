package step2.view;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {

    private static final String START = "[START]";

    private final Scanner scanner;

    public InputView() {
        show(START);
        this.scanner = new Scanner(System.in);
    }

    public int askPurchaseAmount() {
        show("구입금액을 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String askWinnerInput() {
        show("\n지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    private void show(String output) {
        out.println(output);
    }

    public void close() {
        this.scanner.close();
    }
}
