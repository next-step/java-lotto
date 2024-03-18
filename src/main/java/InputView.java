import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int promptForPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}
