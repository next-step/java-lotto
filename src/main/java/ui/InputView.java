package ui;

import java.util.Scanner;

public class InputView {
    private static final String INSERT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int askMoneyAmount(){
        System.out.println(INSERT_MONEY_AMOUNT);
        return scanner.nextInt();
    }
}
