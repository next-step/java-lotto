package step3.ui;

public class InputView {

    public static FastScanner fs = FastScanner.of();

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return fs.nextInt();
    }

    public static String WinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return fs.nextLine();
    }
}
