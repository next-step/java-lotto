import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_GUIDE_TEXT = "구입금액을 입력해 주세요.";
    private static final String LOTTERY_NUMBER_GUIDE_TEXT = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {/* prevent creating instance */}

    public static int getLottoAmounts() {
        System.out.println(PURCHASE_AMOUNT_GUIDE_TEXT);

        Scanner scanner = new Scanner(System.in);
        String stringRottoAmounts = scanner.nextLine();

        return Integer.parseInt(stringRottoAmounts);
    }

    public static String getLotteryNumbersString() {
        System.out.println(LOTTERY_NUMBER_GUIDE_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
