package lotto_second.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String AUTO_PURCHASEAMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_PURCHASEAMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_MANUALNUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(AUTO_PURCHASEAMOUNT_MESSAGE);
        String purchaseAmount = SCANNER.next();
        SCANNER.nextLine();
        return purchaseAmount;
    }

    public String getManualPurchaseAmount() {
        System.out.println(MANUAL_PURCHASEAMOUNT_MESSAGE);
        String purchaseAmount = SCANNER.next();
        SCANNER.nextLine();
        return purchaseAmount;
    }

    public List<String> getManualNumbers(int manualPurchaseAmount) {
        List<String> manualNumbers = new ArrayList<>();
        System.out.println(MANUAL_MANUALNUMBERS_MESSAGE);
        for (int i = 0; i < manualPurchaseAmount; i++) {
            String numbers = SCANNER.nextLine();
            manualNumbers.add(numbers);
        }
        return manualNumbers;
    }


    public String getWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return SCANNER.next();
    }

    public String getBonusNumber() {
        System.out.println(WINNING_BONUS_MESSAGE);
        return SCANNER.next();
    }
}
