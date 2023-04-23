package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int showPaymentConsole() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String showLastWeekWinningNumbersConsole() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
    
}