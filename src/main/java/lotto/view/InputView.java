package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String HOW_MUCH = "구입금액을 입력해 주세요.";
    public static final String LOTTO_NUMBER = NEWLINE + "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL = "보너스 볼을 입력해 주세요.";
    public static final String COUNT_OF_MANUAL = NEWLINE + "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_TICKETS = NEWLINE + "수동으로 구매할 번호를 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static int howMuch() {
        System.out.println(HOW_MUCH);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int countOfManual() {
        System.out.println(COUNT_OF_MANUAL);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> manualTicketStrings(int countOfManual) {
        System.out.println(MANUAL_TICKETS);
        return IntStream.range(0, countOfManual)
                .mapToObj(i -> manualTicket())
                .collect(Collectors.toList());
    }

    private static String manualTicket() {
        return scanner.nextLine();
    }

    public static String winningLotto() {
        System.out.println(LOTTO_NUMBER);
        return scanner.nextLine();
    }

    public static String bonusBall() {
        System.out.println(BONUS_BALL);
        return scanner.nextLine();
    }
}
