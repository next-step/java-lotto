package step2.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MONEY_MESSAGE);
        return scanner.nextInt();
    }

    public int[] inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
