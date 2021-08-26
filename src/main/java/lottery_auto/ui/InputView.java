package lottery_auto.ui;

import java.util.Scanner;

public class InputView {

    private static final String LOTTERY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner LOTTERY_AMOUNT = new Scanner(System.in);

    private int amount;

    public InputView() {
        System.out.println(LOTTERY_MESSAGE);
        this.amount = LOTTERY_AMOUNT.nextInt();
    }

    public int getAmount() {
        return amount;
    }
}
