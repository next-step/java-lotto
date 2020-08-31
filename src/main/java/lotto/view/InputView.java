package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class InputView {

    private static final String PRINT_INPUT_BUY_PRICE = "구입금액을 입력해 주세요.";
    private static final String PRINT_BUY_MANUAL_LOTTO = "수동으로 ";
    private static final String PRINT_BUY_AUTO_LOTTO = "장, 자동으로 ";
    private static final String PRINT_BUY_LOTTO_QUANTITY = "개를 구매했습니다.";
    private static final String PRINT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_LOTTONUMBER = "보너스 볼을 입력해 주세요.";
    private static final String PRINT_INPUT_MANUAL_LOTO_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PRINT_INPUT_MANUAL_LOTO_NUMBER = "수동으로 구매할 로또 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int setPayPriceLotto() {
        System.out.println(PRINT_INPUT_BUY_PRICE);
        return scanner.nextInt();
    }

    public static void printLottoBuyQuantity(int manualQuantity, int autoQuantity) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PRINT_BUY_MANUAL_LOTTO)
                .append(manualQuantity)
                .append(PRINT_BUY_AUTO_LOTTO)
                .append(autoQuantity)
                .append(PRINT_BUY_LOTTO_QUANTITY);
        System.out.println(stringBuffer.toString());
    }

    public static String setWinningNumber() {
        System.out.println(PRINT_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int setBonusLottoNumber() {
        System.out.println(PRINT_BONUS_LOTTONUMBER);
        return scanner.nextInt();
    }

    public static int setManualLottoQuantity() {
        System.out.println(PRINT_INPUT_MANUAL_LOTO_QUANTITY);
        return scanner.nextInt();
    }

    public static void printManualLottoNumber() {
        scanner.nextLine();
        System.out.println(PRINT_INPUT_MANUAL_LOTO_NUMBER);
    }

    public static List<String> inputManualLottoNumber(int manualLottoQuantity) {
        return IntStream.range(NUMBER_ZERO, manualLottoQuantity)
                .mapToObj(input -> scanner.nextLine())
                .collect(Collectors.toList());
    }

}
