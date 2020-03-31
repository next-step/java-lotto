package lotto.View;


import java.util.Scanner;

public class InputView {

    private final String INFORMATION_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private final String INFORMATION_LAST_WEEK_WINNER = "지난 주 당첨 번호를 입력해 주세요.";

    private Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static InputView init() {
        return new InputView();
    }

    public int userInstructionAmount() {
        System.out.println(INFORMATION_BUY_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public String userInstructionWinner() {
        System.out.println(INFORMATION_LAST_WEEK_WINNER);
        return scanner.nextLine();
    }
}
