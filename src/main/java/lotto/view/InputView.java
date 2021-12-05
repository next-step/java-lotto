package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_PURCHASE_PRICE = "구매금액을 입력해주세요.";
    private static final String MANUAL_LOTTO_PURCHASE_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String LAST_WEEK_WIN_LOTTO_MESSAGE = "지난주 당첨번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println(MESSAGE_PURCHASE_PRICE);
        return Integer.parseInt(this.scanner.nextLine());
    }

    public String inputLastWeekWinLotto() {
        System.out.println(LAST_WEEK_WIN_LOTTO_MESSAGE);
        return this.scanner.nextLine();
    }

    public int bonusBall() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return this.scanner.nextInt();
    }

    public List<String> inputChoiceLottoPurchase() {
        System.out.println(MANUAL_LOTTO_PURCHASE_MESSAGE);
        int choicePurchaseCount = Integer.parseInt(this.scanner.nextLine());
        if (choicePurchaseCount < 1) {
            return Collections.EMPTY_LIST;
        }
        System.out.println(MANUAL_LOTTO_NUMBER_MESSAGE);
        List<String> lottoPaper = new ArrayList<>();
        for (int i = 0; i < choicePurchaseCount; i++) {
            lottoPaper.add(this.scanner.nextLine());
        }
        System.out.println();
        return lottoPaper;
    }
}
