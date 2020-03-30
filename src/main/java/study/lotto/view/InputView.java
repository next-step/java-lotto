package study.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";


    public static int getAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(AMOUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WINNING_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextInt();
    }
}
