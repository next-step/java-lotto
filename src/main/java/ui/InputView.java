package ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INSERT_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int askMoneyAmount(){
        System.out.println(INSERT_MONEY_AMOUNT);
        return scanner.nextInt();
    }

    public static List<String> askWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);
        return Arrays.asList(scanner.nextLine().split(","));
    }
}
