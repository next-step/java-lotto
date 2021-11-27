package step2.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTERY_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";


    public String lottoAmount() {
        System.out.println(LOTTO_AMOUNT);
        return scanner.nextLine();
    }

    public String winningLotteryNumbers() {
        System.out.println(WINNING_LOTTERY_NUMBERS);
        return scanner.nextLine();
    }

}
