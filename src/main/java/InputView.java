import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static int promptForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static String promptForWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
