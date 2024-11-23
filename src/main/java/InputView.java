import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Money askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = scanner.nextLine();

        return new Money(moneyStr);
    }

    public static Lotto askWinning() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningStr = scanner.nextLine();

        return new Lotto(winningStr);
    }
}
