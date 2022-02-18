package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String COMMA = ",";
    private static final String MESSAGE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_AMOUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_LAST_WEEK_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int getManualLottoTickets() {
        System.out.println();
        System.out.println(MESSAGE_MANUAL_AMOUNT);
        return scanner.nextInt();
    }

    public static List<List<Integer>> getManualLottoNumbers(final int ticketCount) {
        scanner.nextLine();

        System.out.println();
        System.out.println(MESSAGE_MANUAL_NUMBERS);

        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(convertInputNumbers());
        }

        return tickets;
    }

    public static int getAmount() {
        System.out.println(MESSAGE_AMOUNT);
        return scanner.nextInt();
    }

    public static List<Integer> getComparisonNumbers() {
        System.out.println();
        System.out.println(MESSAGE_LAST_WEEK_NUMBERS);

        return convertInputNumbers();
    }

    public static int getBonus() {
        System.out.println(MESSAGE_BONUS);
        return scanner.nextInt();
    }

    private static List<Integer> convertInputNumbers() {
        return Arrays.stream(scanner.nextLine().split(COMMA))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
