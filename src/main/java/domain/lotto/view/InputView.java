package domain.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String BUYING_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요.";

    private static final String MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getBuyingPrice() {
        System.out.println(BUYING_PRICE_QUESTION);
        return scanner.nextInt();
    }

    public static String getWinningNumber() {
        System.out.println(WINNING_NUMBER_QUESTION);
        return scanner.nextLine();
    }

    public static int getBonusBall() {
        System.out.println(BONUS_BALL_QUESTION);
        return scanner.nextInt();
    }

    public static int getManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_QUESTION);
        return scanner.nextInt();
    }

    public static List<String> getManualLottoNumber(int manualLottoCount) {
        System.out.println(MANUAL_LOTTO_NUMBER_QUESTION);
        List<String> manualLottoNumbers = new ArrayList<>();
        scanner.nextLine();
        while (manualLottoCount > 0) {
            manualLottoNumbers.add(scanner.nextLine());
            manualLottoCount--;
        }

        return manualLottoNumbers;

    }
}
