package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final String LOTTO_PRICE_TOTAL = "구입금액을 입력해주세요.";
    private final String LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final String LOTTO_BONUS_MENTION = "보너스 볼을 입력해 주세요.";
    private final String LOTTO_MANUAL_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final String LOTTO_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private final String NUMBER_DELIMITER = ", ";

    public int inputPrice() {
        System.out.println(LOTTO_PRICE_TOTAL);
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] inputLastWinningNumber() {
        System.out.println(LAST_LOTTO_NUMBER);
        return scanner.nextLine().split(NUMBER_DELIMITER);
    }

    public int inputBonusNumber() {
        System.out.println(LOTTO_BONUS_MENTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputManualLottoQuantity() {
        System.out.println(LOTTO_MANUAL_QUANTITY);
        return Integer.parseInt(scanner.nextLine());
    }

    public void inputManualMention() {
        System.out.println(LOTTO_MANUAL_NUMBER);
    }

    public String[] inputManualNumber() {
        return scanner.nextLine().split(NUMBER_DELIMITER);
    }

}
