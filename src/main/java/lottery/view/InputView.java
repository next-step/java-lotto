package lottery.view;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {
    private final PrintStream out = System.out;
    private final Scanner scanner = new Scanner(System.in);

    public int getMoneyToBuy() {
        out.println("구입금액을 입력해 주세요.");
        int spend = scanner.nextInt();
        scanner.skip("\n");
        return spend;
    }

    public String getWinningNumber() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
